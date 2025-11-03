/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author antal
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections; // For sorting


public class ReportService {

    // This is the main "orchestrator" method.
    public void processIntakes(ArrayList<Intake> intakes) {
        for (Intake intake : intakes) {
            // Run each business logic step for each intake
            checkDoNotReleaseFlags(intake);
            calculateAllCosts(intake);
            sortReportedIssues(intake);
        }
    }

    /**
     * Requirement: If OBD contains P0420 or oil pressure not OK, flag 'Do Not Release'.
     */
    private void checkDoNotReleaseFlags(Intake intake) {
        // 1. Check for P0420
        if (intake.getDiagnostics() != null && intake.getDiagnostics().getObd() != null) {
            for (ObdEntry obd : intake.getDiagnostics().getObd()) {
                if ("P0420".equals(obd.getDtc())) {
                    intake.setDoNotRelease(true);
                    break; // Found it, no need to keep looping
                }
            }
        }

        // 2. Check for Oil Pressure (if not already flagged)
        if (!intake.isDoNotRelease() && intake.getDiagnostics() != null && intake.getDiagnostics().getTests() != null) {
            for (TestEntry test : intake.getDiagnostics().getTests()) {
                if ("Oil pressure".equals(test.getName()) && !test.isOk()) {
                    intake.setDoNotRelease(true);
                    break; // Found it
                }
            }
        }
    }

    /**
     * Requirement: Compute labor/parts cost and courtesy car fee.
     */
    private void calculateAllCosts(Intake intake) {
        double partsAndLabor = 0.0;

        // 1. Calculate parts and labor
        // This uses POLYMORPHISM as required.
        // We call calculateCost() on each WorkOrder object.
        if (intake.getWorkOrders() != null) {
            for (WorkOrder wo : intake.getWorkOrders()) {
                partsAndLabor += wo.calculateCost();
            }
        }
        intake.setPartsAndLaborCost(partsAndLabor);

        // 2. Calculate courtesy car fee
        // "Courtesy car daily fee 15 EUR applies... max 5 days."
        // We'll apply the max fee if true.
        double carFee = 0.0;
        if (intake.getMeta() != null && intake.getMeta().isCourtesyCar()) {
            carFee = 15.0 * 5; // 75.0 EUR
        }
        intake.setCourtesyCarFee(carFee);

        // 3. Calculate total
        intake.setTotalCost(partsAndLabor + carFee);
    }

    /**
     * Requirement: Output prioritized issues by severity (HIGH > MEDIUM > LOW).
     * This uses our Comparator interface.
     */
    private void sortReportedIssues(Intake intake) {
        if (intake.getReportedIssues() != null) {
            // This is the "Sorting via Comparator" requirement.
            Collections.sort(intake.getReportedIssues(), new IssueSeverityComparator());
        }
    }

    /**
     * Requirement: Write report.txt with full details.
     * This method will be called from Main.
     */
    public void writeReport(ArrayList<Intake> intakes, String filename) throws IOException {
        
        PrintWriter writer = null; // Use PrintWriter for easier formatting
        
        try {
            // Use FileWriter to open the file
            writer = new PrintWriter(new FileWriter(filename));
            
            writer.println("======= CAR SERVICE INTAKE REPORT =======");
            writer.println("Total Intakes Processed: " + intakes.size());
            writer.println();
            
            double grandTotal = 0.0;

            for (Intake intake : intakes) {
                grandTotal += intake.getTotalCost();
                
                writer.println("-----------------------------------------");
                writer.println("INTAKE ID: " + intake.getIntakeId());
                
                // --- Do Not Release Flag ---
                if (intake.isDoNotRelease()) {
                    writer.println("*** DO NOT RELEASE ***");
                }
                
                // --- Client and Car ---
                writer.println("Client: " + intake.getClient().getName() + " (" + intake.getClient().getEmail() + ")");
                writer.println("Car: " + intake.getCar().getMake() + " " + intake.getCar().getModel() + " (" + intake.getCar().getVin() + ")");
                
                // --- Sorted Issues ---
                writer.println("Reported Issues (Sorted):");
                if (intake.getReportedIssues() != null) {
                    for (ReportedIssue issue : intake.getReportedIssues()) {
                        writer.println("  - [" + issue.getSeverity() + "] " + issue.getCode());
                    }
                }
                
                // --- Costs ---
                writer.println("COSTS:");
                writer.println("  Parts & Labor: " + String.format("%.2f", intake.getPartsAndLaborCost()) + " EUR");
                writer.println("  Courtesy Car:  " + String.format("%.2f", intake.getCourtesyCarFee()) + " EUR");
                writer.println("  TOTAL:         " + String.format("%.2f", intake.getTotalCost()) + " EUR");
                writer.println();
            }
            
            writer.println("=========================================");
            writer.println("GRAND TOTAL (ALL INTAKES): " + String.format("%.2f", grandTotal) + " EUR");
            writer.println("======= END OF REPORT =======");

        } finally {
            // 4. ALWAYS close the writer in a 'finally' block
            if (writer != null) {
                writer.close();
            }
        }
    }
}

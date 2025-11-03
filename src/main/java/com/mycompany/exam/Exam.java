/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exam;

/**
 *
 * @author antal
 */

import java.util.ArrayList;
import java.io.IOException;


public class Exam {

    public static void main(String[] args) {
        
        // --- 1. PARSING (from Step 13) ---
        DataParser parser = new DataParser();
        ArrayList<Intake> intakes = null;

        try {
            System.out.println("Attempting to parse data.json...");
            intakes = parser.parse("data.json");
            System.out.println("Parsing complete. " + intakes.size() + " valid intakes loaded.");

        } catch (DomainValidationException e) {
            System.err.println("FATAL ERROR: Could not parse file.");
            e.printStackTrace();
            return; // Stop if we can't read the file
        }

        System.out.println("---------------------------------");
        
        // --- 2. BUSINESS LOGIC (New) ---
        if (intakes != null) {
            System.out.println("Running business logic (costs, flags, sorting)...");
            ReportService reportService = new ReportService();
            reportService.processIntakes(intakes); // This runs all the logic
            System.out.println("Logic complete.");
        }
        
        // --- 3. WRITE REPORT FILE (New) ---
        try {
            System.out.println("Writing report.txt...");
            new ReportService().writeReport(intakes, "report.txt");
            System.out.println("Successfully wrote report.txt to project folder.");
        
        } catch (IOException e) {
            System.err.println("FATAL ERROR: Could not write report.txt");
            e.printStackTrace();
        }

        System.out.println("---------------------------------");
        
        // --- 4. PRINT CONSOLE SUMMARY (Requirement) ---
        System.out.println("======= CONSOLE SUMMARY =======");
        double grandTotal = 0.0;
        for (Intake intake : intakes) {
            grandTotal += intake.getTotalCost();
            System.out.println("ID: " + intake.getIntakeId());
            System.out.println("  Total: " + String.format("%.2f", intake.getTotalCost()) + " EUR");
            if (intake.isDoNotRelease()) {
                System.out.println("  *** FLAG: DO NOT RELEASE ***");
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Grand Total (All Intakes): " + String.format("%.2f", grandTotal) + " EUR");
        System.out.println("===============================");
        System.out.println("\nApplication finished.");
    }
}

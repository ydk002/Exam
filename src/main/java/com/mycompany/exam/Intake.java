/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author antal
 */
import java.util.ArrayList;
import java.util.Date; // Use java.util.Date


/**
 * This is our main "hub" class. It represents one "intake"
 * from the JSON file. It extends BaseEntity and implements schedule.
 */
public class Intake extends BaseEntity implements Schedulable {

    // --- Fields from JSON ---
    private String intakeId;
    private Date receivedAt; // For the Schedulable interface
    private Client client;
    private Car car;
    private ArrayList<ReportedIssue> reportedIssues;
    private Diagnostics diagnostics;
    private ArrayList<WorkOrder> workOrders;
    private Invoice invoice;
    private Meta meta;
    
    // --- Business Logic Flag ---
    private boolean doNotRelease = false; // We will set this in Phase 3
    // --- Fields for Business Logic ---
    private double partsAndLaborCost = 0.0;
    private double courtesyCarFee = 0.0;
    private double totalCost = 0.0;

    // --- Overloaded Constructors (Mandatory) ---
    public Intake() {
        // Default constructor for Gson
    }

    public Intake(String intakeId) {
        this.intakeId = intakeId;
    }

    // --- Abstract Method Implementation ---
    @Override
    public String businessKey() {
        // The intakeId is the business key
        return this.intakeId;
    }
    
    /**
     * We override the 'id' field from BaseEntity
     * so it gets set from 'intakeId'
     */
    @Override
    public String getId() {
        return this.intakeId;
    }
    
    // --- Interface Method Implementation (from Schedulable) ---
    @Override
    public Date getAppointmentDate() {
        // We will use the 'receivedAt' time as the appointment time
        return this.receivedAt;
    }

    // --- Overridden toString() (Mandatory) ---
    @Override
    public String toString() {
        return "Intake[id=" + intakeId + "]";
    }
    
    // --- Getters and Setters ---
    // (These are all required for the logic and parser)

    public String getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(String intakeId) {
        this.intakeId = intakeId;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ArrayList<ReportedIssue> getReportedIssues() {
        return reportedIssues;
    }

    public void setReportedIssues(ArrayList<ReportedIssue> reportedIssues) {
        this.reportedIssues = reportedIssues;
    }

    public Diagnostics getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Diagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    public ArrayList<WorkOrder> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(ArrayList<WorkOrder> workOrders) {
        this.workOrders = workOrders;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public boolean isDoNotRelease() {
        return doNotRelease;
    }

    public void setDoNotRelease(boolean doNotRelease) {
        this.doNotRelease = doNotRelease;
    }
    // --- Getters and Setters for Costs ---

    public double getPartsAndLaborCost() {
        return partsAndLaborCost;
    }

    public void setPartsAndLaborCost(double partsAndLaborCost) {
        this.partsAndLaborCost = partsAndLaborCost;
    }

    public double getCourtesyCarFee() {
        return courtesyCarFee;
    }

    public void setCourtesyCarFee(double courtesyCarFee) {
        this.courtesyCarFee = courtesyCarFee;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}

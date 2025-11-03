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

/**
 * Represents a single issue reported by the client (formerly Issue).
 * This is the parent class for our inheritance hierarchy.
 */
public class ReportedIssue extends BaseEntity {

    // --- Fields from JSON ---
    // Note: 'id' is in BaseEntity, but the JSON doesn't have one for this.
    // Gson will just leave it null, which is fine.
    private String severity; // "HIGH", "MEDIUM", "LOW"
    private String code;     // e.g., "ENG-OIL-LEAK"
    private ArrayList<String> symptoms;

    // --- Abstract Method Implementation ---
    @Override
    public String businessKey() {
        // The 'code' is the best business key here.
        return this.code;
    }

    // --- Overridden toString() ---
    @Override
    public String toString() {
        return "Issue[code=" + code + ", severity=" + severity + "]";
    }

    // --- Getters and Setters ---
    // (In NetBeans: right-click -> Insert Code... -> Getter and Setter...)

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<String> symptoms) {
        this.symptoms = symptoms;
    }
}

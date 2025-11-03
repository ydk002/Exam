/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author antal
 */
/**
 * CONCRETE subclass for inheritance.
 * This represents an electrical issue.
 * It inherits 'severity', 'code', etc. from ReportedIssue.
 */
public class ElectricalIssue extends ReportedIssue {
    
    // We can add electrical-specific fields here later if we want,
    // like 'voltage' or 'requires-canbus'.
    
    @Override
    public String toString() {
        // We use getCode() and getSeverity() from the parent class
        return "ElectricalIssue[code=" + getCode() + ", severity=" + getSeverity() + "]";
    }
}
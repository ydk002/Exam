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
 * This represents a mechanical issue.
 * It inherits 'severity', 'code', etc. from ReportedIssue.
 */
public class MechanicalIssue extends ReportedIssue {
    
    // We can add mechanical-specific fields here later if we want,
    // like 'torque-specs' or 'fluid-type'.
    // For now, it's just a marker for our inheritance requirement.
    
    @Override
    public String toString() {
        // We use getCode() and getSeverity() from the parent class
        return "MechanicalIssue[code=" + getCode() + ", severity=" + getSeverity() + "]";
    }
}

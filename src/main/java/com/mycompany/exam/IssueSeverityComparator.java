/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author antal
 */
import java.util.Comparator;

/**
 * Comparator to sort Issues by severity (HIGH > MEDIUM > LOW).
 */
public class IssueSeverityComparator implements Comparator<ReportedIssue> {

    @Override
    public int compare(ReportedIssue o1, ReportedIssue o2) {
        // TODO: Add logic to compare severity strings
        return 0;
    }
    
}

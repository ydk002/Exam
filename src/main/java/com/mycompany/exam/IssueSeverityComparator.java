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
    public int compare(ReportedIssue r1, ReportedIssue r2) {
        // Get severity strings, handle nulls to prevent crashes
        String s1 = (r1 != null && r1.getSeverity() != null) ? r1.getSeverity() : "";
        String s2 = (r2 != null && r2.getSeverity() != null) ? r2.getSeverity() : "";

        // 1. Check for "HIGH"
        if (s1.equals("HIGH") && !s2.equals("HIGH")) {
            return -1; // r1 comes first
        }
        if (!s1.equals("HIGH") && s2.equals("HIGH")) {
            return 1; // r2 comes first
        }

        // 2. Check for "MEDIUM" (we know neither is HIGH at this point)
        if (s1.equals("MEDIUM") && !s2.equals("MEDIUM")) {
            return -1; // r1 comes first
        }
        if (!s1.equals("MEDIUM") && s2.equals("MEDIUM")) {
            return 1; // r2 comes first
        }

        // 3. Check for "LOW" (we know neither is HIGH or MEDIUM)
        if (s1.equals("LOW") && !s2.equals("LOW")) {
            return -1; // r1 comes first
        }
        if (!s1.equals("LOW") && s2.equals("LOW")) {
            return 1; // r2 comes first
        }

        // 4. If they are the same (or both unknown), consider them equal
        return 0;
    }
}

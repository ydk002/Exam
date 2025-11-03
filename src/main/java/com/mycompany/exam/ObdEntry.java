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
 * A simple POJO to hold one "obd" entry
 * from the diagnostics section.
 */
public class ObdEntry {

    // Field names MUST match the JSON keys
    private String dtc; // e.g., "P0420"
    private String status;

    // --- Getters and Setters ---
    public String getDtc() {
        return dtc;
    }

    public void setDtc(String dtc) {
        this.dtc = dtc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

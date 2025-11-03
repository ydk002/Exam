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
 * A simple POJO to hold the "diagnostics" object,
 * which contains lists of OBD entries and tests.
 */
public class Diagnostics {

    // Field names MUST match the JSON keys
    private ArrayList<ObdEntry> obd;
    private ArrayList<TestEntry> tests;

    // --- Getters and Setters ---
    public ArrayList<ObdEntry> getObd() {
        return obd;
    }

    public void setObd(ArrayList<ObdEntry> obd) {
        this.obd = obd;
    }

    public ArrayList<TestEntry> getTests() {
        return tests;
    }

    public void setTests(ArrayList<TestEntry> tests) {
        this.tests = tests;
    }
}

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
 * A simple POJO to hold "meta" data.
 */
public class Meta {

    // Fields MUST match the JSON keys
    private String priority;
    private boolean courtesyCar;

    // --- Getters and Setters ---
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCourtesyCar() {
        return courtesyCar;
    }

    public void setCourtesyCar(boolean courtesyCar) {
        this.courtesyCar = courtesyCar;
    }
}

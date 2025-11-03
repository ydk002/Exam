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
 * Represents a single labor task.
 * This is a billable item.
 */
public class Task extends BaseEntity implements Billable {

    // --- Fields from JSON ---
    // 'id' is in BaseEntity
    private String desc;
    private double laborH;
    private double hourly;

    // --- Interface Method Implementation ---
    /**
     * Calculates the cost of this task.
     * This is an example of polymorphism as required by the exam.
     */
    @Override
    public double calculateCost() {
        // Labor cost = hours * hourly rate
        // Add a check for bad data from the "trap" file
        if (laborH < 0 || hourly < 0) {
            return 0; 
        }
        return this.laborH * this.hourly;
    }

    // --- Abstract Method Implementation ---
    @Override
    public String businessKey() {
        // The task's 'id' is its business key
        return this.id;
    }
    
    // --- Overridden toString() ---
    @Override
    public String toString() {
        return "Task[id=" + id + ", desc=" + desc + ", cost=" + calculateCost() + "]";
    }

    // --- Getters and Setters ---
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getLaborH() {
        return laborH;
    }

    public void setLaborH(double laborH) {
        this.laborH = laborH;
    }

    public double getHourly() {
        return hourly;
    }

    public void setHourly(double hourly) {
        this.hourly = hourly;
    }
}

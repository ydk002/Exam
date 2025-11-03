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
 * Represents a single work order, which contains billable
 * tasks and parts. This class itself is Billable.
 */
public class WorkOrder implements Billable {

    // --- Static Counter ---
    private static int workOrderCounter = 0;

    // --- Fields from JSON ---
    private String type; // e.g., "MECHANICAL"
    private ArrayList<Task> tasks;
    private ArrayList<Part> parts;
    
    // --- Constructor ---
    public WorkOrder() {
        workOrderCounter++;
    }
    
    // --- Static method for counter ---
    public static int getWorkOrderCount() {
        return workOrderCounter;
    }

    /**
     * Calculates the total cost of this ENTIRE work order.
     * It does this by calling calculateCost() on every
     * billable item (Task and Part) it contains.
     *
     * This is a CORE example of POLYMORPHISM.
     */
    @Override
    public double calculateCost() {
        double totalCost = 0.0;

        // 1. Calculate cost of all tasks
        if (tasks != null) {
            for (Task task : tasks) {
                // Here we call calculateCost() on a Task object
                totalCost += task.calculateCost();
            }
        }

        // 2. Calculate cost of all parts
        if (parts != null) {
            for (Part part : parts) {
                // Here we call calculateCost() on a Part object
                totalCost += part.calculateCost();
            }
        }

        return totalCost;
    }
    
    // --- Overridden toString() ---
    @Override
    public String toString() {
        return "WorkOrder[type=" + type + ", totalCost=" + calculateCost() + "]";
    }

    // --- Getters and Setters ---
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
}
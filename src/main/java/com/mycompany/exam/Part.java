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
 * Represents a single part.
 * This is also a billable item.
 */
public class Part extends BaseEntity implements Billable {

    // --- Fields from JSON ---
    // 'id' is in BaseEntity, but we'll use 'sku'
    private String sku;
    private String name;
    private int qty;
    private double unitPrice;

    // --- Interface Method Implementation ---
    /**
     * Calculates the cost of this part (or parts).
     * This is an example of polymorphism as required by the exam.
     */
    @Override
    public double calculateCost() {
        // Part cost = quantity * price per unit
        // Add a check for bad data from the "trap" file
        if (qty < 0 || unitPrice < 0) {
            return 0;
        }
        return this.qty * this.unitPrice;
    }

    // --- Abstract Method Implementation ---
    @Override
    public String businessKey() {
        // The 'sku' (Stock Keeping Unit) is the business key
        return this.sku;
    }

    // --- Overridden toString() ---
    @Override
    public String toString() {
        return "Part[sku=" + sku + ", name=" + name + ", cost=" + calculateCost() + "]";
    }

    // --- Getters and Setters ---
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

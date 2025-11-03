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
 * Represents the Car (formerly Vehicle).
 * Inherits from BaseEntity.
 */
public class Car extends BaseEntity {

    // --- Fields from JSON ---
    // Note: 'id' is in BaseEntity, but we'll use 'vin' from the JSON
    // The JSON parser will map "vin" to this field.
    private String vin;
    private String make;
    private String model;
    private int year;
    private int odometerKm;
    private boolean warrantyActive;
    
    // This is from the "diagnostics.tests" section,
    // a bit of a-ha, but we need it for the "Do Not Release" flag.
    // We can populate this later.
    private boolean oilPressureOK = true; // Default to true

    // --- Abstract Method Implementation ---
    @Override
    public String businessKey() {
        // The Vehicle Identification Number (VIN) is the perfect business key.
        return this.vin;
    }
    
    // --- Overridden toString() ---
    @Override
    public String toString() {
        return "Car[vin=" + vin + ", make=" + make + ", model=" + model + "]";
    }
    
    // --- Getters and Setters ---
    // (In NetBeans: right-click -> Insert Code... -> Getter and Setter...)

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometerKm() {
        return odometerKm;
    }

    public void setOdometerKm(int odometerKm) {
        this.odometerKm = odometerKm;
    }

    public boolean isWarrantyActive() {
        return warrantyActive;
    }

    public void setWarrantyActive(boolean warrantyActive) {
        this.warrantyActive = warrantyActive;
    }

    public boolean isOilPressureOK() {
        return oilPressureOK;
    }

    public void setOilPressureOK(boolean oilPressureOK) {
        this.oilPressureOK = oilPressureOK;
    }
}

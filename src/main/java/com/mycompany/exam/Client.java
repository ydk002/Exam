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
 * Represents the Client (formerly Customer).
 * Inherits from BaseEntity.
 */
public class Client extends BaseEntity {

    // --- Fields from JSON ---
    // Note: 'id' is already in BaseEntity
    private String name;
    private String phone;
    private String email;

    // --- Abstract Method Implementation ---
    @Override
    public String businessKey() {
        // The client's ID is their business key
        return this.id;
    }

    // --- Overridden toString() ---
    @Override
    public String toString() {
        return "Client[id=" + id + ", name=" + name + "]";
    }
    
    // --- Getters and Setters ---
    // (You can add these now or later)
    // (In NetBeans: right-click -> Insert Code... -> Getter and Setter...)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

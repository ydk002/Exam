/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author antal
 */
public abstract class BaseEntity {

    protected String id;

    /**
     * A unique key for this entity (e.g., VIN, Work Order #).
     * @return The business key as a String.
     */
    public abstract String businessKey();

    // --- Getters / Setters ---
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // --- hashCode() and equals() ---
    // These are implemented ONCE here and inherited by all children.
    
    /**
     * hashCode() is based on the businessKey().
     * This is documented as per exam requirements.
     */
    @Override
    public int hashCode() {
        if (businessKey() == null) {
            return 0;
        }
        return businessKey().hashCode();
    }

    /**
     * equals() is based on the businessKey().
     * This is documented as per exam requirements.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        
        if (businessKey() == null) {
            return other.businessKey() == null;
        }
        return businessKey().equals(other.businessKey());
    }

    /**
     * A default toString()
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + id + "]";
    }
}

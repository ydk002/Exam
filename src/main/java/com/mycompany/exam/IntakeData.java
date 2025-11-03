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
 * This is a helper class. Its only job is to match the root
 * of the JSON file, which is an object containing a list
 * called "intakes".
 */
public class IntakeData {

    // The variable name "intakes" MUST match the JSON key
    private ArrayList<Intake> intakes;

    public ArrayList<Intake> getIntakes() {
        return intakes;
    }

    public void setIntakes(ArrayList<Intake> intakes) {
        this.intakes = intakes;
    }
}

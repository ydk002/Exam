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

public class DataParser {

    /**
     * Parses the JSON file into a list of WorkOrders.
     * @param filename Path to the data.json file
     * @return A list of WorkOrder objects
     * @throws DomainValidationException if parsing fails
     */
    public ArrayList<Intake> parse(String filename) throws DomainValidationException {
        // TODO: Add FileReader and Gson logic here
        System.out.println("Parsing file (stub)...");
        return new ArrayList<Intake>();
    }
}

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


public class ReportService {

    /**
     * Processes orders to calculate costs and flags.
     * @param orders The list of orders to process
     */
    public void processOrders(ArrayList<Intake> orders) {
        // TODO: Add logic for 'Do Not Release' flags, etc.
        System.out.println("Processing orders (stub)...");
    }
    
    /**
     * Writes the final report.txt file.
     * @param orders The processed list of orders
     * @param filename The output file path
     */
    public void writeReport(ArrayList<Intake> orders, String filename) {
        // TODO: Add FileWriter logic here
        System.out.println("Writing report (stub)...");
    }
}

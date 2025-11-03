/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exam;

/**
 *
 * @author antal
 */

import java.util.ArrayList;


public class Exam {

    public static void main(String[] args) {
        
        // 1. Create an instance of your parser
        DataParser parser = new DataParser();
        
        // 2. Create a list to hold the results
        ArrayList<Intake> intakes = null;

        try {
            // 3. Run the parser
            // Make sure "data.json" is in the root of your NetBeans project
            // (the same folder as your 'src' and 'build' folders)
            System.out.println("Attempting to parse data.json...");
            intakes = parser.parse("data.json");
            System.out.println("---------------------------------");
            
            // 4. Print a success message
            if (intakes != null) {
                System.out.println("SUCCESS!");
                System.out.println("Loaded " + intakes.size() + " valid intakes.");
                
                // Let's print the IDs to be sure
                for (Intake intake : intakes) {
                    System.out.println(" - Loaded Intake: " + intake.getIntakeId());
                }
            }

        } catch (DomainValidationException e) {
            // 5. Handle any fatal parsing errors
            System.err.println("FATAL ERROR: Could not parse file.");
            e.printStackTrace();
        }
    }
}

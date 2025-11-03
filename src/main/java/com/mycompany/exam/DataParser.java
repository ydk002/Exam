/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam;

/**
 *
 * @author antal
 */
// Import all the Gson classes we need
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.FileReader; // Mandatory: Use FileReader
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles reading and parsing the data.json file.
 * This includes defensively handling "trap" data.
 */
public class DataParser {

    /**
     * Parses the JSON file into a list of valid Intake objects.
     *
     * @param filename Path to the data.json file
     * @return A list of *only* the valid Intake objects
     * @throws DomainValidationException if the file itself can't be read
     */
    public ArrayList<Intake> parse(String filename) throws DomainValidationException {

        ArrayList<Intake> validIntakes = new ArrayList<Intake>();
        Gson gson = new Gson();
        FileReader reader = null; // Must be declared outside try for finally

        try {
            // 1. Open the file (as required)
            reader = new FileReader(filename);

            // 2. Use JsonParser to read the file as a generic object
            JsonParser parser = new JsonParser();
            JsonObject rootObject = (JsonObject) parser.parse(reader);
            
            // 3. Get the "intakes" array from the root object
            JsonArray intakesArray = rootObject.getAsJsonArray("intakes");

            // 4. Loop through each element in the array
            System.out.println("Starting parser... Found " + intakesArray.size() + " total entries.");
            for (JsonElement intakeElement : intakesArray) {
                
                // 5. THIS IS THE TRAP HANDLER
                // Try to parse one entry. If it fails, catch it and move on.
                try {
                    // 6. Convert this one element into our Intake class
                    Intake intake = gson.fromJson(intakeElement, Intake.class);

                    // 7. Validation Check (Mandatory)
                    // Check for nulls or bad data that Gson might allow
                    if (intake.getIntakeId() == null || intake.getIntakeId().isEmpty()) {
                        throw new DomainValidationException("Entry has missing or empty intakeId.");
                    }
                    if (intake.getCar() == null || intake.getCar().getVin() == null) {
                        throw new DomainValidationException("Entry has missing car or VIN data.");
                    }

                    // 8. If we get here, it's a good entry
                    validIntakes.add(intake);
                    
                } catch (JsonSyntaxException e) {
                    // This catches type errors like year: "two thousand..."
                    System.err.println("--- SKIPPED CORRUPTED ENTRY (Bad JSON) ---");
                    System.err.println("Error: " + e.getMessage());
                } catch (DomainValidationException e) {
                    // This catches our own validation errors (e.g., missing ID)
                    System.err.println("--- SKIPPED INVALID ENTRY (Bad Data) ---");
                    System.err.println("Error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            // This catches file-not-found, etc.
            throw new DomainValidationException("Failed to read file: " + filename, e);
        } catch (Exception e) {
            // Catch-all for other errors (e.g., file is not JSON at all)
            throw new DomainValidationException("An unknown parsing error occurred.", e);
        } finally {
            // 6. ALWAYS close the reader in a 'finally' block (Java 6)
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Failed to close FileReader: " + e.getMessage());
            }
        }

        System.out.println("Parsing complete. " + validIntakes.size() + " valid intakes loaded.");
        return validIntakes;
    }
}

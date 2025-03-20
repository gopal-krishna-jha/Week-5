package com.csvdatahandling.day01;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Create a class DetectDuplicate to detect duplicates in a CSV File
class DetectDuplicate{

    //Create a static method detectDuplicateInCSVFile to detect duplicates in a CSV File and print
    public static void detectDuplicateInCSVFile(String filePath){
        //Use try-catch block to handle the exception
        try {
            //Create an object of CSVReader
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create a variable to store
            String[] nextLine;

            //Create a HashMap
            Map<String, String[]> studentMap = new HashMap<>();
            Set<String> duplicateIds = new HashSet<>();

            //Use while loop the read file line-by-line
            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];
                if (studentMap.containsKey(id)) {
                    //Call the add method
                    duplicateIds.add(id);
                } else {
                    //add to map
                    studentMap.put(id, nextLine);
                }
            }
            reader.close();

            // Print the duplicate records
            if (duplicateIds.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String id : duplicateIds) {
                    String[] details = studentMap.get(id);
                    System.out.println(String.join(", ", details));
                }
            }

        }
        catch (IOException ex) {//Catch block to handle Exception
            System.out.println(ex.getMessage());
        }catch (CsvValidationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

//Create a class DetectDuplicatesInCSVFile to use DetectDuplicate class
public class DetectDuplicatesInCSVFile {
    public static void main(String[] args) {
        //Create a String variable to store the file path
        String filePath = "src/main/java/com/csvdatahandling/day01/StudentRecord.csv";

        //call the method
        DetectDuplicate.detectDuplicateInCSVFile(filePath);

    }
}

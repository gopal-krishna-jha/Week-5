package com.csvdatahandling.day01;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Create a class Merge to merge the two csv file and write in new file
class Merge{
    //Create a static method mergeTwoFile to merge the two file
    public static void mergeTwoFile(String StudentDetails1,String StudentDetails2,String MergeStudentDetails){
        //Use try-catch block to handle the exception
        try {
            //Create a hashmap
            Map<String, String[]> studentMap = new HashMap<>();

            //Create an object od CSVReader class to read first CSV file
            CSVReader reader1 = new CSVReader(new FileReader(StudentDetails1));

            //Create a variable to store vaiable
            String[] nextLine;


            while ((nextLine = reader1.readNext()) != null) {
                studentMap.put(nextLine[0], nextLine);
            }
            reader1.close();

            //Create an object of CSVReader class to read second CSV file and merge data
            CSVReader reader2 = new CSVReader(new FileReader(StudentDetails2));

            //Use for loop
            while ((nextLine = reader2.readNext()) != null) {
                if (studentMap.containsKey(nextLine[0])) {
                    String[] details1 = studentMap.get(nextLine[0]);
                    String[] mergedDetails = new String[details1.length + nextLine.length - 1];

                    System.arraycopy(details1, 0, mergedDetails, 0, details1.length);
                    System.arraycopy(nextLine, 1, mergedDetails, details1.length, nextLine.length - 1);

                    studentMap.put(nextLine[0], mergedDetails);
                }
            }
            reader2.close();

            // Write merged data to the output CSV file
            CSVWriter writer = new CSVWriter(new FileWriter(MergeStudentDetails));
            for (String[] details : studentMap.values()) {
                writer.writeNext(details);
            }
            writer.close();

            //Print the result
            System.out.println("CSV files merged successfully!");

        } catch (IOException ex) {//Catch block handle exception
            //Print the result
            System.out.println("Error "+ex.getMessage());
        } catch (CsvValidationException ex) {//catch block handle exception
            //Print the result
            System.out.println("Error "+ex.getMessage());
        }
    }
}

//Create a class MergeCSVFiles
class MergeTwoCSVFiles {

    public static void main(String[] args) {
        //Create a String variables to store the file path
        String StudentDetails1 = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\StudentRecord.csv";
        String StudentDetails2 = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\StudentRecord2.csv";
        String MergeStudentDetails = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\MergeStudnetRecord.csv";

        //call the method
        Merge.mergeTwoFile(StudentDetails1,StudentDetails2,MergeStudentDetails);
    }
}

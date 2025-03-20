package com.csvdatahandling.day01;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

//Create a class FilterRecord
class FilterRecord{

    //Create a static method to filter student record using marks
    public static void filterUsingMarks(String filePath,int marks){

        //use try block to handle the exception
        try{
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create an array of string
            String[] data=reader.readNext();

            //Print the record
            System.out.printf("%-5s %-5s  %-16s %-5s %s\n", data[0], data[1], data[2], data[3], data[4]);

            //Use while loop filter records
            while ((data = reader.readNext()) !=null) {

                //Check the condition and print the details
                if (Integer.parseInt(data[4]) >= marks) {
                    //Print the data
                    System.out.printf("%-5s %-5s  %-16s %-5s %s\n", data[0], data[1], data[2], data[3], data[4]);
                }
            }
        } catch (IOException e) {//Catch block to handle IOException
            //Print the statement
            System.out.println("Error"+e.getMessage());
        } catch (CsvValidationException e) {//Catch block to handle CsvValidationException
            //Print the statement
            System.out.println("Error:" + e.getMessage());
        }

    }
}

//Create a class FilterRecordsFromCSV
public class FilterRecordsFromCSV {
    public static void main(String[] args) {
        //Create a variable to store file path
        String filePath ="C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\StudentRecord.csv";

        //Print the statement
        System.out.println("Student Details who have scored more than 80 Marks: \n");

        //Call the method to filter the records and print the result
        FilterRecord.filterUsingMarks(filePath,80);
    }
}

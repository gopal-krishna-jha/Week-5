package com.csvdatahandling.day01;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Create a class Modify to read and modify it
class Modify{
    //Create a static method modifyACSVFile to take argument as csv filePath and newFilePath to update salary of employee from the "IT" department by 10%
    public static void modifyACSVFile(String filePath,String newFilePath){
        //Use try-catch block to handle the exceptions
        try {
            //Create an Object of csvReader class
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            //Create an Object of CSVWriter class
            CSVWriter csvWriter = new CSVWriter(new FileWriter(newFilePath));
            //Create a List to store employee details
            List<String[]> employeeDetails = csvReader.readAll();
            List<String[]> updatedEmployeeDetails = new ArrayList<>();

            //use for loop to iterate employee list
            for (String[] record : employeeDetails) {
                if (record[2].equals("IT")) {
                    Double salary = Double.parseDouble(record[3]);
                    salary = salary * 110 / 100;
                    record[3] = "" + salary;
                }
                //Call the add method
                updatedEmployeeDetails.add(record);
            }

            //write employee data in updated csv file using writeAll method
            csvWriter.writeAll(updatedEmployeeDetails);

            //call the method flush
            csvWriter.flush();

            //print the statement
            System.out.println("IT Employee Salary Successfully Increased By 10%....");
        } catch (CsvException ex){//Catch block to handle exception
            //Print the result
            System.out.println(ex.getMessage());
        } catch(IOException e){//Catch block to handle exception
            //Print the result
            System.out.println(e.getMessage());
        }
    }
}

//Create a class ModifyACSVFile to use Modify class
public class ModifyACSVFile {
    public static void main(String[] args) {
        //Create a string variable to store new file path
        String filePath="C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\EmployeeRecord.csv";

        //Create a string variable to store file path
        String newFilePath="C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\Update_EmployeeRecord.csv";

        //call the method
        Modify.modifyACSVFile(filePath,newFilePath);
    }
}

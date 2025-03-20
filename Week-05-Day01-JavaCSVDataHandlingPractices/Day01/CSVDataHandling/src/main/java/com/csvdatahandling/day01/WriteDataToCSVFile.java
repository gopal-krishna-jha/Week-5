package com.csvdatahandling.day01;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Create a class WriteCSVFile to write data into CSV file
class WriteCSVFile{

    //Create a method to write data into file
    public static void writeDataIntoFile(String filePath){

        //Use try block
        try {
            //Create an object of CSVWrite class
            CSVWriter writeData = new CSVWriter(new FileWriter(filePath));

            //Create a list to store the employee data
            List<String[]> employeeRecord = new ArrayList<>();

            //Call the add method to add employee details
            employeeRecord.add(new String[]{"S.NO","ID","NAME","Department","SALARY"});
            employeeRecord.add(new String[]{"1","1001","Anchal Sahu","IT","50000"});
            employeeRecord.add(new String[]{"2","1002","Nilesh Yadav","HR","60000"});
            employeeRecord.add(new String[]{"3","1003","Roshan Lodhi","Finance","25000"});
            employeeRecord.add(new String[]{"4","1004","Divyansh Sharma","IT","15000"});
            employeeRecord.add(new String[]{"5","1005","Hariom Rajput","HR","35000"});
            employeeRecord.add(new String[]{"6","1006","Pradeep Meena","IT","55000"});

            //Call the writeAll method to write the all data into file
            writeData.writeAll(employeeRecord);

            //Call the flush method
            writeData.flush();

            System.out.println("Task Completed!");
        } catch (IOException e) {//Catch block to handle IOException

            //Print the statement
            System.out.println("Error "+e.getMessage());
        }
    }
}

//Create a class WriteDataToCSVFile
public class WriteDataToCSVFile {
    public static void main(String[] args) {
        //Create a variable to store the file path
        String filePath = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\EmployeeRecord.csv";

        //call the method to write data into given file
        WriteCSVFile.writeDataIntoFile(filePath);
    }
}

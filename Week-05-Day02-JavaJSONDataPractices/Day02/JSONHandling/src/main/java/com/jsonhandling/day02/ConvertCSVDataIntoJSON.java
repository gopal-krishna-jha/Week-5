package com.jsonhandling.day02;

import com.google.gson.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;

//create a class Employee
class Employee{

    //Create private instance variables to store data
    private String ID;
    private String name;
    private String salary;

    //Parameterized constructor to initialize variable
    public Employee(String ID, String name, String salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }
}

//Create a class CSVToJson to convert CSV file to Json file
class CSVToJson{
    //Create a static method to write the json dile
    public static void writeJson(List<Employee> dataList, String jsonFile) {
        //Create an object of Gson class
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //Use try block
        try (FileWriter writer = new FileWriter(jsonFile)) {//Create an object of FileWriter

            //Call the method
            gson.toJson(dataList, writer);

            //Print the statement
            System.out.println("Write Successfully.");
        } catch (IOException e) {//Catch block to handle exception

            //Print the statement
            System.out.println("Error "+e.getMessage());
        }
    }

    //Create a static method to read csv file
    public static List<Employee> readCsvFile(String csvFile) {
        //Create a list to store value
        List<Employee> dataList = new ArrayList<>();

        //Create an aray
        String[] data ;

        //Use try block
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {//Create an object of CSVReader class
            data = reader.readNext();
            while ((data = reader.readNext()) != null) {
                Employee emp = new Employee(data[0], data[1], data[2]);
                dataList.add(emp);
            }
        } catch (IOException e) {//catch block to handle exception

            //Print the statement
            System.out.println("Error "+e.getMessage());
        } catch (CsvValidationException e) {//catch block to handle exception

            //Print the statement
            System.out.println("Error "+e.getMessage());
        }
        return dataList;
    }
}

//Create a class ConvertCSVDataIntoJSON
public class ConvertCSVDataIntoJSON {

    public static void main(String[] args) {

        //Create a variable to store the file path
        String csvFilePath = "C:\\Users\\hp\\IdeaProjects\\JSONHandling\\src\\main\\java\\com\\jsonhandling\\day02\\EmployeeRecord.csv";
        String jsonFilePath = "C:\\Users\\hp\\IdeaProjects\\JSONHandling\\src\\main\\java\\com\\jsonhandling\\day02\\Employee.json";

        //Create a list and call the method
        List<Employee> dataList = CSVToJson.readCsvFile(csvFilePath);

        //Call the method
        CSVToJson.writeJson(dataList, jsonFilePath);
    }
}

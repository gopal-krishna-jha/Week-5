package com.jsonhandling.day02;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

//Create a class Employee2
class Employee2 {
    //Create private variable to store value
    private int id;
    private String name;
    private double salary;

    //Create a getter method
    public int getId() {
        return id;
    }

    //Create a setter method
    public void setId(int id) {
        this.id = id;
    }

    //Create a getter method
    public String getName() {
        return name;
    }

    //Create a setter method
    public void setName(String name) {
        this.name = name;
    }

    //Create a getter method
    public double getSalary() {
        return salary;
    }

    //Create a setter method
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

//Create a class JsonStructureValidation
class JsonStructureValidation{
    //Create a static method checkIsJsonStructureValid
    public static void checkIsJsonStructureValid(String filePath){
        //Create an object of ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();

        //USe try block
        try {

            //Create an object of Employee2
            Employee2[] employee = mapper.readValue(new File(filePath), Employee2[].class);

            System.out.println("JSON structure is valid.");
            System.out.println("Employee Details:");
           for(Employee2 emp: employee) {
               //Print the result
               System.out.println("id: " + emp.getId());
               System.out.println("name: " + emp.getName());
               System.out.println("salary: " + emp.getSalary());
           }
        } catch (IOException e) {//Catch block to handle exception

            //Print the result
            System.out.println("Invalid JSON structure: " + e.getMessage());
        }
    }
}

//Create a class ValidateJSONStructureUsingJackson
public class ValidateJSONStructureUsingJackson {
    public static void main(String[] args) {

        //Create a variable to store the filepath
        String filePath = "C:\\Users\\hp\\IdeaProjects\\JSONHandling\\src\\main\\java\\com\\jsonhandling\\day02\\EmployeeRecord.json";

        //Call the method
        JsonStructureValidation.checkIsJsonStructureValid(filePath);
    }
}

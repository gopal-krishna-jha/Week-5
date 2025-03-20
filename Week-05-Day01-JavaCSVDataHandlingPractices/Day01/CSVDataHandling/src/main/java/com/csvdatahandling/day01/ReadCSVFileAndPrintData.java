package com.csvdatahandling.day01;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;


//Create a class ReadingCSVFile to read the file
class ReadingCSVFile{

    //Create a static method to read file and print the data
    public static void readFileAndPrint(String filePath){

        //use try block to handle the exception
        try{
            //Create an object of CSVReader class
            CSVReader reader = new CSVReader(new FileReader(filePath));

            //Create an array of string
            String[] data;

            //Use while loop to read file and print the data
            while ((data = reader.readNext()) !=null){
                //Print the data
                System.out.printf("%-5s %-5s  %-16s %-5s %s\n",data[0],data[1],data[2],data[3],data[4]);
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

//Create a class ReadCSVFileAndPrintData
public class ReadCSVFileAndPrintData {
    public static void main(String[] args) {

        //Create a variable to store the filePath
        String filePath = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\StudentRecord.csv";

        //Call the method
        ReadingCSVFile.readFileAndPrint(filePath);
    }
}

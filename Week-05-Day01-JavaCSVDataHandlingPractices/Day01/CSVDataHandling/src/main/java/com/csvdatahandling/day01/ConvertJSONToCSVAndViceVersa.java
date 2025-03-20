package com.csvdatahandling.day01;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Create a class ConvertJSONToCSV to convert Json to CSV file
class ConvertJSONToCSV {

    //Create a static convertJsonToCSV  method
    public static void convertJsonToCSV(String jsonFilePath, String csvFilePath) throws IOException {

        //Create a variable to store value
        String jsonString = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

        //Create an JSONArray object
        JSONArray jsonArray = new JSONArray(jsonString);

        //Create an object of CSVWriter
        CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));
        writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

        //Use for loop
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String[] csvData = {
                    jsonObject.getString("ID"),
                    jsonObject.getString("NAME"),
                    jsonObject.getString("AGE"),
                    jsonObject.getString("MARKS"),
                    jsonObject.getString("GRADE")
            };
            writer.writeNext(csvData);
        }
        writer.close();

        //Print the statement
        System.out.println("JSON to CSV conversion completed successfully.");
    }

    //Create  a method csvToJSON
    public static void csvToJSON(String csvFilePath, String jsonFilePath) throws IOException, CsvValidationException {
        //Create an object of CSVReader
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));

        //Create an object of JSONArray
        JSONArray jsonArray = new JSONArray();

        //Create a variable to store value
        String[] nextLine;

        //Create an array of String
        String[] headers = reader.readNext(); // Assuming first line is the header

        while ((nextLine = reader.readNext()) != null) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < headers.length; i++) {
                jsonObject.put(headers[i], nextLine[i]);
            }
            jsonArray.put(jsonObject);
        }
        reader.close();
        //Call the method
        Files.write(Paths.get(jsonFilePath), jsonArray.toString(4).getBytes());

        //Print the method
        System.out.println("CSV to JSON conversion completed successfully.");
    }
}

//Create a class ConvertJSONToCSVAndViceVersa
public class ConvertJSONToCSVAndViceVersa {
    public static void main(String[] args) {
        //Create a variable to store the filePath
        String jsonFilePath = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\Student.json";
        String csvFilePath = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\StudentRecord.csv";
        String outputJsonFilePath = "C:\\Users\\hp\\IdeaProjects\\CSVDataHandling\\src\\main\\java\\com\\csvdatahandling\\day01\\Student_Output.json";

        //Use try block
        try {
            //Call the method to convert JSON to CSV
            ConvertJSONToCSV.convertJsonToCSV(jsonFilePath, csvFilePath);

            //Call the method to convert CSV to JSON
            ConvertJSONToCSV.csvToJSON(csvFilePath, outputJsonFilePath);
        } catch (IOException e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error"+e.getMessage());
        }catch(Exception e) {//Catch block to handle exception
            //Print the statement
            System.out.println("Error "+e.getMessage());
        }
    }
}

package com.jsonhandling.day02;

import java.io.FileReader;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.ValidationException;

//Create a class ValidateEmailUsingJSONSchema
public class ValidateEmailUsingJSONSchema {
    public static void main(String[] args) {
        try {
            //Create an object of FileReader class
            FileReader schemaReader = new FileReader("C:\\Users\\hp\\IdeaProjects\\JSONHandling\\src\\main\\java\\com\\jsonhandling\\day02\\email-schema.json");

            //Create an object of JSONObject class
            JSONObject schemaObject = new JSONObject(new JSONTokener(schemaReader));
            Schema schema = SchemaLoader.load(schemaObject);

            //Create an object of FileReader class
            FileReader dataReader = new FileReader("C:\\Users\\hp\\IdeaProjects\\JSONHandling\\src\\main\\java\\com\\jsonhandling\\day02\\email-data.json");
            JSONObject jsonData = new JSONObject(new JSONTokener(dataReader));

            //call the method
            schema.validate(jsonData); // throws a ValidationException if the data is invalid

            //Print the statement
            System.out.println("Email is valid!");

        } catch (ValidationException e) {//Catch block to handle exception
            System.out.println("Email is invalid: " + e.getMessage());
        } catch (Exception e) {//Catch block to handle exception
            System.out.println("Error "+e.getMessage());
        }
    }
}

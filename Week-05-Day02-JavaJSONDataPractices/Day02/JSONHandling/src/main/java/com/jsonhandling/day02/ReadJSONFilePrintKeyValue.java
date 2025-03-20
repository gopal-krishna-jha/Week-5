package com.jsonhandling.day02;



import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

//Create a class ReadJSONFileAndPrint to read a JSON file and print all keys and values.
class ReadJSONFileAndPrint {
    //Create a static method jsonFilePrintKeyValue to read a JSON file and print all keys and values.
    public static void jsonFilePrintKeyValue(JSONObject jsonObject) {
        //Use a iterator to iterate jsonObject
        Iterator<?> keys = jsonObject.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object value = jsonObject.get(key);
            System.out.println(key + " : " + value);
            if (value instanceof JSONObject) {
                jsonFilePrintKeyValue((JSONObject) value);
            }
        }
    }
}

//Create a class ReadJSONFilePrintKeyValue to use ReadJSONFileAndPrint class
public class ReadJSONFilePrintKeyValue {
    public static void main(String[] args) {
        //Create a variable filePath to store file path
        String filePath = "C:\\Users\\hp\\IdeaProjects\\JSONHandling\\src\\main\\java\\com\\jsonhandling\\day02\\StudentDetails.json";
        //Use try-catch block to handle the exception
        try {
            //Create FileReader class object to read the file
            FileReader reader = new FileReader(filePath);
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
            reader.close();

            String jsonString = sb.toString();
            JSONObject jsonObject = new JSONObject(jsonString);
            //call the method
            ReadJSONFileAndPrint.jsonFilePrintKeyValue(jsonObject);
        }
        //Hande the exception using catch block
        catch (IOException | ClassCastException ex){
            System.out.println(ex.getMessage());
        }

    }
}
package com.jsonhandling.day02;

import org.json.JSONObject;

//Create a class Student
class Student{

    //Create private variable to store value
    private String name;
    private int age;
    private String[] subjects;

    //Parameterized constructor to initialize variable
    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    //Create a getter method
    public String getName() {
        return name;
    }

    //Create a getter method
    public int getAge() {
        return age;
    }

    //Create a getter method
    public String[] getSubjects() {
        return subjects;
    }
}
//Create a class CreateJsonObjectForStudent
public class CreateJsonObjectForStudent {
    public static void main(String[] args) {

        //Create an object of student class
        Student student1 = new Student("Alok",24,new String[]{"Java","OS","DBMS"});
        Student student2 = new Student("Rishi",22,new String[]{"C","DBMS","Computer Network"});

        //Create an object of JSONObject class
        JSONObject studentObject  = new JSONObject();

        //Call the put method
        studentObject.put("Name",student1.getName());
        studentObject.put("Age",student1.getAge());
        studentObject.put("Subjects",student1.getSubjects());

        //Create an object of JSONObject class
        JSONObject studentObject2  = new JSONObject();

        //Call the put method
        studentObject2.put("Name",student2.getName());
        studentObject2.put("Age",student2.getAge());
        studentObject2.put("Subjects",student2.getSubjects());

        //Create an object of JSONObject class
        JSONObject students = new JSONObject();

        //Call the put method
        students.put("Student1 ",studentObject);
        students.put("Student2 ",studentObject2);

        //Print the result
        System.out.println(students.toString(4));

    }
}

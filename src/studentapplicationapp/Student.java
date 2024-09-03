/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentapplicationapp;

import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    //declaring the variables
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    // Constructor
    public Student(String id, String name, int age, String email, String course)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public String getId()
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getEmail()
    {
        return email;
    }
    public String getCourse() 
    {
        return course;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }

    @Override
    public String toString()
    {
        return ColorClass.PURPLE_BOLD + "STUDENT ID: " + id + "\n" +
               "STUDENT NAME: " + name + "\n" +
               "STUDENT AGE: " + age + "\n" +
               "STUDENT EMAIL: " + email + "\n" +
               "STUDENT COURSE: " + course;
    }
}


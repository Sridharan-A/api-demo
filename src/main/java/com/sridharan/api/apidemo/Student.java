package com.sridharan.api.apidemo;

import java.util.InputMismatchException;

public class Student {

    private String name;
    private int rollNumber;
    private String department;

    public Student() {
    }

    public Student(int rollNumber, String name, String department) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        if(rollNumber <=0){
            throw new InputMismatchException("invalid roll number. it should be greater than zero");
        }
        this.rollNumber = rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



}

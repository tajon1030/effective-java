package org.example.chapter3.item23.good;

public class HighStudent extends Student implements StudentType {
    final String department;

    public HighStudent(String department) {

        this.department = department;
    }


    @Override
    public String getDescription() {
        return "High school student in " + department + " department";
    }
}

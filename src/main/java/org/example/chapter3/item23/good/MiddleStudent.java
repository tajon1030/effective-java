package org.example.chapter3.item23.good;

public class MiddleStudent extends Student implements StudentType {
    final String department;

    public MiddleStudent(String department) {
        this.department = department;
    }

    @Override
    public String getDescription() {
        return "Middle school student in " + department + " department";
    }
}



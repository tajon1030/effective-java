package org.example.chapter3.item23.factroy;

public class HighStudent extends Student {
    private String department;

    public HighStudent(String department) {
        this.department = department;
    }

    @Override
    public Type getType() {
        return Type.HIGH;
    }

    @Override
    public String getDescription() {
        return "High school student in " + department + " department";
    }
}

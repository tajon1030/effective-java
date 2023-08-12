package org.example.chapter3.item23.factroy;

public class MiddleStudent extends Student {
    private String department;

    public MiddleStudent(String department) {
        this.department = department;
    }

    @Override
    public Type getType() {
        return Type.MIDDLE;
    }

    @Override
    public String getDescription() {
        return "Middle school student in " + department + " department";
    }
}

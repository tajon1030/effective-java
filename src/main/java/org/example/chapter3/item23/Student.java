package org.example.chapter3.item23;

public class Student {
    enum Type { ELEMENTARY, MIDDLE, HIGH };

    // 태그 필드
    final Type type;

    // ELEMENTARY일 때만 사용하는 필드
    int grade;

    // MIDDLE, HIGH일 때만 사용하는 필드
    String department;

    public Student(int grade) {
        type = Type.ELEMENTARY;
        this.grade = grade;
    }

    public Student(String department) {
        if(department.equals("middle")) {
            type = Type.MIDDLE;
        } else if(department.equals("high")) {
            type = Type.HIGH;
        } else {
            throw new IllegalArgumentException("Invalid department");
        }
        this.department = department;
    }

    public String getDescription() {
        switch(type) {
            case ELEMENTARY:
                return "Elementary " + grade + " grade student";
            case MIDDLE:
                return "Middle school student in " + department + " department";
            case HIGH:
                return "High school student in " + department + " department";
            default:
                throw new AssertionError(type);
        }
    }
}
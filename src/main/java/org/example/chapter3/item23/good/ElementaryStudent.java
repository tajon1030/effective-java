package org.example.chapter3.item23.good;

public class ElementaryStudent extends Student implements StudentType {
    final int grade;

    public ElementaryStudent(int grade) {

        this.grade = grade;
    }

    @Override
    public String getDescription() {
        return "Elementary " + grade + " grade student";
    }
}

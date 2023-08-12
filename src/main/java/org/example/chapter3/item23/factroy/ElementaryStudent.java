package org.example.chapter3.item23.factroy;

public class ElementaryStudent extends Student {
    private int grade;

    public ElementaryStudent(int grade) {
        this.grade = grade;
    }

    @Override
    public Type getType() {
        return Type.ELEMENTARY;
    }

    @Override
    public String getDescription() {
        return "Elementary " + grade + " grade student";
    }
}

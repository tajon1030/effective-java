package org.example.chapter2.Item17.example;

public class NewStudent extends Student {
    private String newName;

    public NewStudent(String name, boolean isGoodStudy, int grade) {
        super(name, isGoodStudy, grade);
        newName = name;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    @Override
    public String getName() {
        return this.newName;
    }
}

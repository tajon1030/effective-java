package org.example.chapter2.Item17.example;

public  class Student {
    private String name;
    private boolean isGoodStudy;
    private  int grade;

    private Friend friend;

    public Student(String name, Friend friend) {
        this.name = name;
        this.friend = friend;
//        this.friend = new Friend(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoodStudy(boolean goodStudy) {
        isGoodStudy = goodStudy;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isGoodStudy() {
        return isGoodStudy;
    }

    public Student(String name, boolean isGoodStudy, int grade) {
        this.name = name;
        this.isGoodStudy = isGoodStudy;
        this.grade = grade;
    }
}

package org.example.chapter2.Item17.example;

import java.util.List;

public class Student {
    private String name;
    private boolean isGoodStudy;
    private  int grade;
    private Friend friend;
    private List<Friend> friends;


    public Friend getFriend() {
        return friend;
    }

    public Student(String name, Friend friend) {
        this.name = name;
//        this.friend = friend;/**/
        this.friend = new Friend(name);
    }

    public String getName() {
        return name;
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

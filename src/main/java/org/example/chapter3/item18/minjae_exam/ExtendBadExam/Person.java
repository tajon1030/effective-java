package org.example.chapter3.item18.minjae_exam.ExtendBadExam;

import java.util.ArrayList;
import java.util.List;

public class Person {
    protected List<String> mbti;
    public Person(List<String> mbti) {
        this.mbti = new ArrayList<>(mbti);
    }
    public String getMBTI(int index){
        return this.mbti.get(index);
    }
}

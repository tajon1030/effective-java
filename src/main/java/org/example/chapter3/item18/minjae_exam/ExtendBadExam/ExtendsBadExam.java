package org.example.chapter3.item18.minjae_exam.ExtendBadExam;

import java.util.ArrayList;

public class ExtendsBadExam {
    public static void main(String[] args) {
        ArrayList<String> mbti = new ArrayList<>();
        mbti.add("E");
        mbti.add("N");
        mbti.add("P");
        FPerson fperson = new FPerson(mbti);
//        System.out.println(fperson.getAll());

    }
}

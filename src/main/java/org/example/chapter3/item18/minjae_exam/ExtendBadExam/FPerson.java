package org.example.chapter3.item18.minjae_exam.ExtendBadExam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FPerson extends Person{
    private final String f = "F";

    public FPerson(ArrayList<String> mbti) {
        super(mbti);
    }

    public String getAll() {
        List<String> mbtiList = mbti.stream().collect(Collectors.toList());
        mbtiList.add(2, f); // "I" 값을 "N"과 "P" 사이에 추가합니다.
        return String.join("", mbtiList);
    }
}

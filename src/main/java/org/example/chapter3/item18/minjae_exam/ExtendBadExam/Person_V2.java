package org.example.chapter3.item18.minjae_exam.ExtendBadExam;

import java.util.List;

public class Person_V2 {
    // 만약 요구사항 바뀌면?
    protected List<StringBuilder> mbti;

    public Person_V2(List<StringBuilder> mbti) {
        this.mbti = mbti;
    }

    public List<StringBuilder> getMbti() {
        return mbti;
    }
}

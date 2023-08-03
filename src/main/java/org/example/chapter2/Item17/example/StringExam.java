package org.example.chapter2.Item17.example;

import org.example.chapter2.Item17.Person;

import java.util.ArrayList;
import java.util.List;

public class StringExam {
    public static void main(String[] args) {
        String a = "안녕";
        a = a.concat("하세요");
        System.out.println(a);

        StringBuilder name2 = new StringBuilder("값이");
        ImmutableStringBuilder immutableString2 = new ImmutableStringBuilder(name2);
        name2.append("바뀔까");
        System.out.println(immutableString2);
//
//        String name = "값이";
//        name.concat("바뀔까");
//        parentClass parentClass = new parentClass(name);
//        parentClass.setName("값을");
    }
}

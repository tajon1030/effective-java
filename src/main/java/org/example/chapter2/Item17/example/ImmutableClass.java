package org.example.chapter2.Item17.example;

import java.util.ArrayList;
import java.util.List;

public class ImmutableClass {

//1. 멤버변수를 final로 선언.
    private final String name;
    private List<Names> names;

    public ImmutableClass(String name, List<Names> names) {
        this.name = name;
        this.names = names;
//        this.names = new ArrayList<>(names);
    }


//2. 접근 메서드를 구현하지 않는다. (Setter메서드)

    public List<Names> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", names=" + names +
                '}';
    }
}
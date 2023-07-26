package org.example.chapter2.Item17;

import java.util.List;

public class Person {

    private final String name;
    private final List<CanModify> canModifies;

    public Person(final String name, final List<CanModify> canModifies) {
        this.name = name;
        this.canModifies = canModifies;
    }

    public String name() {
        return name;
    }

    public List<CanModify> canModifies() {
        return canModifies;
    }
}

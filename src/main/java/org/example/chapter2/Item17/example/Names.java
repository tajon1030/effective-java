package org.example.chapter2.Item17.example;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private String name;

    public Names(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Names{" +
                "name=" + name +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

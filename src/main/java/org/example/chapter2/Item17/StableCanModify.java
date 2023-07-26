package org.example.chapter2.Item17;

public class StableCanModify {

    private String name;

    public StableCanModify(final String name) {
        this.name = name;
    }

    public StableCanModify(final StableCanModify canModify) {
        this.name = canModify.name;
    }


    public String name() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }}
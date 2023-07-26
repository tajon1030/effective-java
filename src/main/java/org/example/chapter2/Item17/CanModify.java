package org.example.chapter2.Item17;

public class CanModify {
    private String name;

    public CanModify(final String name) {
        this.name = name;
    }

    public CanModify(final CanModify canModify) {
        this.name = canModify.name;
    }


    public String name() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
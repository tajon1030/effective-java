package org.example.chapter3.item23.factroy;

public abstract class Student {
    public enum Type { ELEMENTARY, MIDDLE, HIGH };

    public abstract Type getType();
    public abstract String getDescription();

    public static Student create(ElementaryStudent elementaryStudent) {
        return elementaryStudent;
    }

    public static Student create(MiddleStudent middleStudent) {
        return middleStudent;
    }

    public static Student create(HighStudent highStudent) {
        return highStudent;
    }
}


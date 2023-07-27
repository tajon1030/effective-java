package org.example.chapter2.Item17.example;

public class ImmutableClass {

//1. 멤버변수를 final로 선언.
    private final String name;

    ImmutableClass(String name){
        this.name = name;
    }
//2. 접근 메서드를 구현하지 않는다. (Setter메서드)
    @Override
    public String toString(){
        return this.name;
    }

}
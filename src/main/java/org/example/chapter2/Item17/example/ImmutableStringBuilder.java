package org.example.chapter2.Item17.example;

public class ImmutableStringBuilder {

    private final StringBuilder name;

    ImmutableStringBuilder(StringBuilder name){
        this.name = name;
    }

    @Override
    public String  toString(){
        return this.name.toString();
    }

}
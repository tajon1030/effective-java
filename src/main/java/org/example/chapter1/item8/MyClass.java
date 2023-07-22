package org.example.chapter1.item8;

public class MyClass {
    private int checkNum;

    public MyClass(int checkNum) {
        this.checkNum =checkNum;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(checkNum + "에 있는 finalize()실행");
    }

}
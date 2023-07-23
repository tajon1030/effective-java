package org.example.chapter1.item8;

public class MyFinalizer {
    private int checkNum;

    public MyFinalizer(int checkNum) {
        this.checkNum =checkNum;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(checkNum + "에 있는 finalize()실행");
    }

}
package org.example.chapter4.item19;

public class Helper {
    public Helper() {
        helperMethod();
    }

    public void overrideMe() {
        helperMethod();
    }

    private void helperMethod()  {
        System.out.println("hi");
    }
}
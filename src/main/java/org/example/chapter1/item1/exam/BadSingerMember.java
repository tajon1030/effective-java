 package org.example.chapter1.item1.exam;

public class BadSingerMember implements Singable {
    private String name;
    @Override
    public void sing() {
        System.out.println("못 부름");
    }
}

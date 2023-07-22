package org.example.chapter1.item1.exam;

public class GoodSingerMember implements Singable{
    private String name;
    @Override
    public void sing() {
        System.out.println("잘 부름");
    }
}

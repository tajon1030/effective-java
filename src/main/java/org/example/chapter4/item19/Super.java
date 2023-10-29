package org.example.chapter4.item19;

public class Super {
    public Super() {
        // 생성자가 재정의 가능 메서드를 호출하는 잘못된 코드
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("hi");
    }
}
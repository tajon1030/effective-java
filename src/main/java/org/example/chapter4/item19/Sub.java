package org.example.chapter4.item19;

import java.util.Date;

public class Sub extends Super {
    // 초기화되지 않은  final 필드. 생성자에서 초기화한다.
    private final Date date;

    public Sub() {
        date = new Date();
    }

    // 재정의가능 메서드, 상위클래스의 생성자가 호출한다.
    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}

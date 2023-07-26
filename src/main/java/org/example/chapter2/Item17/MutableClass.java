package org.example.chapter2.Item17;

public class MutableClass {
    private String name;
    // 2. 클래스 확장 할 수 있도록 함

    public MutableClass(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 1. 객체의 상태를 변경하는 메서드(변경자)를 제공함
    public void setName(String name) {
        this.name = name;
    }
}

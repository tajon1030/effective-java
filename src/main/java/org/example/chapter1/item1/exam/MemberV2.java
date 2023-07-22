package org.example.chapter1.item1.exam;

public class MemberV2 {
    private String name;
    private int age;
    private int height;
    private int weight;
    private String gender;

    private MemberV2(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // 1. 따라서 이름을 갖는 정적 메소드로 만들면 명시적으로 이름 가질 수 있음
    // 2. 동일한 시그니처를 갖는 복수의 생성자를 갖는 효과
    public static MemberV2 createMemberWithHeight(String name, int age, int height) {
        return new MemberV2(name, age, height);
    }

}

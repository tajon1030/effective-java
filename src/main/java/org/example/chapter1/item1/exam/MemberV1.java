package org.example.chapter1.item1.exam;

public class MemberV1 {
    private String name;
    private int age;
    private int height;
    private int weight;
    private String gender;

    // 1. 필수로 받고자하는 파라미터 받아 생성자 만듦
    public MemberV1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 다른 파라미터 넣고싶으면 생성자 오버로딩

    public MemberV1(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    // 2. 생성자는 하나의 시그니처만 사용
    /**
     * 생성자는 하나의 시그니처만 사용하므로, 다음과 같이 생성자 생성이 불가능
     *
     *  public Member(String name) {
     *         this.name = name;
     *     }
     *   public Member(String gender) {
     *         this.gender = gender;
     *     }
     */




}

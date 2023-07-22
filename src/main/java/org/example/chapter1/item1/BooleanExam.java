package org.example.chapter1.item1;

public class BooleanExam {
    public static void main(String[] args) {

        // 랩퍼 클래스인 불린의 정적 팩토리 메소드 valueOf(해당 값이 불린형인지 판단)
        // 불린 인스턴스를 미리 생성하여 반환
        Boolean bool = Boolean.valueOf(true);
        System.out.println(bool);
    }

}

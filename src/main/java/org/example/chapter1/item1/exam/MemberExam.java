package org.example.chapter1.item1.exam;

import java.util.*;

public class MemberExam {
    public static void main(String[] args) {
        // 문제는 멤버 클래스 불러올 때 생성자 안에 넣는 매개변수 많으면 어떤타입인지 기억해서 넣기 어려움
        MemberV1 member = new MemberV1("이름", 1);

        MemberV2 member2 = MemberV2.createMemberWithHeight("이름2", 12, 180);

        // 두번쨰 뭔지 기억나는 분 - 이름을 갖지 못하는 게 단점
        // 3. 호출될 때마다 매번 새로운 객체를 생성할 필요가 없음 - 스태틱으로 런타임 시 이미 선언된 상태
        System.out.println(System.identityHashCode(member2));
        System.out.println(System.identityHashCode(member2));
        System.out.println(System.identityHashCode(member2));
        System.out.println(System.identityHashCode(member2));

        // 4. 반환 타입에 하위 타입 객체를 반환할 수 있는 유연성
        // 5. 입력 매개 변수에 따라 다른 클래스의 객체를 반환할 수 있음
        Singable badSinger = SingerFactory.createSinger("BadSingerMember");
        badSinger.sing();
        Singable goodSinger = SingerFactory.createSinger("GoodSingerMember");
        goodSinger.sing();

        // 6. 반환할 객체의 클래스가 존재하지 않아도 됌
        Singable singer2 = SingerFactory.createSingerV2("org.example.chapter1.item1.exam.BadSingerMember");
        singer2.sing();
    }
}

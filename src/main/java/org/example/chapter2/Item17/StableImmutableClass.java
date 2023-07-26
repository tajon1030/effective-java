package org.example.chapter2.Item17;

import java.util.ArrayList;
import java.util.List;

public class StableImmutableClass {
    private final String name;
    private final List<Integer> list;
    // > final을 사용하면 값을 바꿀 수 없기 때문에, 명시적으로 값을 불변 > 새로 생성된 인스턴스를 동기화 없이 다른 스레드에 전달하더라도 문제없이 동작하게끔 동작하는 데에도 필요

    public String getName() {
        return name;
    }

    public List<Integer> getList() {
        return list;
    }

    //생성자를 private 혹은 package-private(default)로 만들기
    //패키지 바깥의 클라이언트에서 본 이 객체는 사실상 final
    // public이나 protected생성자도 없기에 다른 패키지에서는 이 클래스를 확장하는게 불가능

    private StableImmutableClass(final String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }
    // public 정적 팩터리 메서드를 제공
    // > 정적 팩토리 방식은 다수의 구현 클래스를 활용한 유연성을 제공 +  객체 캐싱 기능을 추가해 성능을 끌어올릴 수도

    public static StableImmutableClass createStableImmutableClass(final String name){
        return new StableImmutableClass(name);
    }

    //가변 객체를 참조하는 필드가 하나라도 있다면 클라이언트에서 그 객체의 참조를 얻을 수 없도록
    // >필드는 클라이언트가 제공한 객체 참조를 그대로 사용해서는 안되며, 접근자 메서드가 그 필드를 그대로 반환해서도
    //생성자와 접근자 메서드에서 방어적 복사를 수행
}

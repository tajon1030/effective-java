package org.example.chapter2.Item17;

import java.util.ArrayList;
import java.util.List;

public class UnStableImmutableClass {
    public final String name;
    // 1. 객체의 상태를 변경하는 메서드(변경자)를 제공하지 않음 > Setter 메소드 생성하지 말기
    // 3. 모든 필드를 final 로 선언
    // 4.  모든 필드를 private로 선언한다
    // > public final로만 선언하더라도 불변 객체로 만들 수 있지만, 이렇게 된다면 이후 버전들에서 내부 필드명을 바꿀 수 없으므로 private로 선언하는 것을 권장

    // 5. 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다
    public final List<Integer> list;

    public String getName() {
        return name;
    }

    public List<Integer> getList() {
        return list;
    }

    public UnStableImmutableClass(final String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }


// 2. 클래스를 확장할 수 없도록 한다. > 상속가능하도록 만들지 말기
    // 클래스를 final로 설정하는 방법, private(or default) 생성자 + 정적 팩터리 메서드를 사용한 방법
}

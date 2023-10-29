package org.example.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 대칭성 위배 (54-55쪽)
// 대소문자를 구별하지않는 문자열 클래스
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // 한 방향으로만 작동한다!
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    // 문제 시연 (55쪽)
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        // 대칭성 위배
        cis.equals(s); // true
        s.equals(cis); // false - String 은 CaseInsensitiveString 의 존재를 모름

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(s)); // true? false?
    }

//    // 수정한 equals 메서드 - 다른 타입은 지원하지 말아야한다.
//    @Override public boolean equals(Object o) {
//        return o instanceof CaseInsensitiveString &&
//                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
//    }
}

package org.example.chapter1.item8;

public class MyCleanerExam {
    public static void main(String[] args) throws Exception {
        // 3. MyClass 객체를 생성 doSomething() 메소드를 호출하면 Resource 객체가 활용
        try (MyCleaner obj = new MyCleaner()) {
            obj.doSomething();
        }
        // 4.try-with-resource문을 사용하면 자동으로 close()가 호출  - CLEANER의 clean() 메소드가 호출되어 Resource 객체가 정리
    }
}

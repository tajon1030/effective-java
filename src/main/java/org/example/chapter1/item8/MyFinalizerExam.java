package org.example.chapter1.item8;

public class MyFinalizerExam {
    public static void main(String[] args) {

        for(int i = 0; i < 100000; i++) {
            MyFinalizer test = new MyFinalizer(i);

            test = null;
            //null 값을 넣어 기존에 있는 값을 쓰레기로 만듬
            // 가비지 컬렉터의 동작 방식은 일정하지 않기 때문에, System.gc() 메소드를 명시적으로 호출
            System.gc();
            //가비지 컬렉터 실행 - 실제로 호출되기 전까지 메모리에서 삭제되지 않음
        }

    }
}

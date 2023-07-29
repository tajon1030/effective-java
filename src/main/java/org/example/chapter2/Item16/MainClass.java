package org.example.chapter2.Item16;


// package-private 클래스 : 같은 패키지 내에서 접근가능
class PackagePrivateClass {
    public String message="package-private 클래스";
}


public class MainClass{

    // private 중첩 클래스 : MainClass 내에서 접근 가능
    public static class PrivateNestedClass{
        public String message="private 중첩 클래스";
    }


    public static void main(String[] args) {

        PackagePrivateClass obj1 = new PackagePrivateClass();
        obj1.message = "package-private Class!!";

        PrivateNestedClass obj2 = new PrivateNestedClass();
        obj2.message = "private Nested Class!! ";

        System.out.println(obj1.message);
        System.out.println(obj2.message);

    }
}

/*
 package-private 클래스 혹은 private 중첩 클래스라면 데이터 필드를 노출한다 해도 하등의 문제가 없다.
 그러나, 필드에 직접 접근하는것보다 메서드를 통해서 접근하는것이 더욱 안전하다!

 1. package-private 클래스
    : 같은 패지키 내에서 접근가능하기 때문에 public 클래스보다 접근범위가 줄어들어 변경에 따른 위험이 상대적으로 적음
      public 클래스의 경우 어디서 사용하는지 알기 어렵지만, 사용하는 클라이언트도 해당 클래스를 포함하는 패키지 안에서만 동작하기 때문
 2. private 중첩 클래스
    :  Outer 클래스 내에서만 접근 가능하기 때문에 수정 범위가 좁아져서 이 클래스를 포함하는 외부 클래스까지로 제한되어 변경에 따른 위험 적음

*/




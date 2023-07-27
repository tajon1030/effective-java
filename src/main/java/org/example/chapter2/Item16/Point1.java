package org.example.chapter2.Item16.point;

// 16-1[필드접근] 캡슐화의 이점을 제공하지 못하는 public 필드
public class Point1 {
    public double x;
    public double y;

    public static void main(String[] args) {
        Point1 point = new Point1();
        point.x = 10;
        point.y = 12;

        access(point); // 만약, 특정 메서드를 실행한다면 point.x, point.y의 값을 보장할수 없음

        System.out.println(point.x);
        System.out.println(point.y);
    }


    // public 필드를 사용한다면, 불필요하게 아래와 같이 방어적 복사를 해서 사용
    private static void access(Point1 point) {
        Point1 localPoint = new Point1();
        localPoint.x = point.x;
        localPoint.y = point.y;
    }

}

/*
    16-1[필드접근] 캡슐화의 이점을 제공하지 못하는 public 필드
    : 직접 필드에 접근하기 때문에 불변을 보장할수 없고, 외부에서 필드에 값이 들어올때 부수 작업(검증,입력값의 제한등)을 수행할수 없음

      방어적 복사? 내부의 값을 안전하게 보장하기 위해 사용한다. (p.303 : 아이템 50 - 적시에 방어적 복사본을 만들라)
      생성자의 인자로 받은 객체의 복사본을 만들어 내부필드를 초기화 하거나 getter메서드에서 내부의 객체를 반환할때, 객체의 복사본을 만들어 반환하는것
*/

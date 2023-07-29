package org.example.chapter2.Item16.point;

// 16-2[메소드접근] 접근자와 변경자 메서드를 활용해 데이터를 캡슐화
public class Point2 {

    private double x;
    private double y;

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}

/*
   16-2[메소드접근] 접근자와 변경자 메서드를 활용해 데이터를 캡슐화
   : private 접근제어자를 사용해 외부클래스, 패키지에서 직접 접근하지 못하도록하고,
     setter, getter 메서드를 통해 필드에 접근하는 방식을 사용
     이렇게 메서드를 통해서 접근하기 때문에 특정조건(검증, 제한)을 설정하여 부가적인 작업이 가능
*/

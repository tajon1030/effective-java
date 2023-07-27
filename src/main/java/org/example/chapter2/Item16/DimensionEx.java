package org.example.chapter2.Item16;

import java.awt.*;

public class DimensionEx {

    public static void main(String[] args) {
        Button button = new Button("Button!!");
        button.setBounds(0,0,20,10);

        Dimension size = button.getSize(); // getSize가 리턴하는것이 Dimension
        System.out.println(size.height);
        System.out.println(size.width);

        access(size);

    }

    private static void access(Dimension dimension) {
        // dimension.width = 30;  불변 보장X
        Dimension dm = new Dimension();
        dm.width = dimension.width;
        dm.height = dimension.height;
    }
}

/*

java.awt.Dimension 클래스 - 특정 영역의 사각형과 폭과 높이의 값을 관리할 수 있도록 도와주는 클래스
: awt패키지가 아니지만 필드에 접근하여 사용하고 있으며 Dimension클래스 내부를 보면 필드를 public하게 노출하고 있음
  height, width가 언제 어디서 바뀔지 모르기 때문에 사용하는 클라이언트쪽에서 방어적복사를 사용해야함
  언제 어디서 Dimension을 이용하더라도 copy를 통해서 사용해야되며 copy하는 순간부터 불필요한 인스턴트를 생성해 point예제 동일한 문제 발생함
*/




/*

참고페이지

p.378 : 아이템 67 - 최적화는 신중히 하라
public 타입을 가변으로 만들면, 내부 데이터를 변경할수 있게 만들려면 불필요한 방어 복사를 수없이 유발할수 있음!

p.303 : 아이템 50 - 적시에 방어적 복사본을 만들라
Period 인스턴스의 내부를 보호하려면 생성자에서 받은 가변 매개 변수 각각을 방어적으로 복사해야한다.
그런다음, Period 인스턴스 안에서는 원본이 아닌 복사본을 사용한다.
생성자를 사용하면 앞에있는 값의 변경에 더이상 위협되지 않음!
매개변수의 유효성 검사를 하기전에 방어적 복사본을 만들고, 이 복사본으로 유효성을 검사한 점에 주목하자!

*/

## item10. equals는 일반규약을 지켜 재정의하라

equals를 재정의 하지 않는 것이 최선
### 1. equals가 필요 없는 경우
다음의 경우 equals를 재정의 할 필요가 없다.
- 각 인스턴스가 본질적으로 고유하다.(싱글톤)
- 인스턴스의 논리적 동치성을 검사할 필요가 없다.
- 상위클래스에서 재정의한 equals가 하위클래스에도 적절하다.  
(대부분의 Set구현체는 상위 AbstractSet이 구현한 equals를 상속받아 쓰고있다.)
- 클래스가 private이거나 package-private이고 equals메서드를 호출할 일이 없다.  
(public클래스의 경우는 어떻게 쓰일지 예측불가)


### 2. equals 규약
#### 1) 반사성
A.equals(A) == true  
객체는 자기자신과 같아야한다.

#### 2) 대칭성
A.equals(B) == B.equals(A)  
- CaseInsensitiveString

#### 3) 추이성
A.equals(B) == true, B.equals(C) == true 면 A.equals(C) 도 true 다.  
- Point, ColorPoint(inherit), CounterPoint, ColorPoint(comp)
- 구체클래스를 확장해 새로운 값을 추가하면서 equals 규약을 만족시킬 방법은 존재하지 않는다.
-> 우회법 : 상속대신 컴포지션을 사용

#### 4) 일관성
A.equals(B) == A.equals(B) : 반복호출하면 항상 같은 값을 반환  
- 가변객체는 비교시점에 따라 같을수도 혹은 다를수도있지만  
불변객체는 항상 같은 값을 반환해야한다.
- equals의 판단에 신뢰할수없는 자원이 끼어들게 해서는 안된다.  
(ex java.net.URL : 매핑된 호스트의 IP주소를 이용해서 비교하여 문제를 일으킴)

#### 5) null 아님
A.equals(null) == false  
- 명시적 null검사 필요없이 equals의 형변환에앞서 instanceof 연산자로 타입검사를 통해 처리

### 3. equals 구현방법과 주의사항
1) == 연산자를 사용해 자기자신의 참조인지 확인한다.
2) instance 연산자로 올바른 타입인지 확인한다.
3) 입력된 값을 올바른 타입으로 형변환한다.
4) 입력객체와 자기자신의 대응되는 **핵심필드**가 일치하는지 확인한다.
- float와 double 을 제외한 기본타입 필드는 == 연산자로 비교하고 나머지는 equals로 비교한다.
- null도 정상값으로 취급된다면 Objects.equals()로 NPE 발생을 예방한다.

- 구글의 AutoValue 혹은 Lombok을 사용
- IDE의 코드생성기능을 사용(필드 추가시마다 새로 정의해줄수있도록 주의)

- equals를 재정의할땐 hashCode도 반드시 재정의하자
- 너무 복잡하게 해결하려들지 말자
- Object가 아닌 타입의 매개변수를 받는 equals 메서드는 선언하지말자(오버로딩이 아니라 오버라이딩이어야함)

### 핵심정리
꼭 필요한 경우가 아니면 equals를 재정의하지 말자.  
많은 경우에 Object의 equals가 원하는 비교를 정확히 수행해준다.  
재정의해야할 때는 그 클래스의 핵심 필드 모두를 빠짐없이, 다섯가지 규약을 확실히 지켜가며 비교해야한다.  
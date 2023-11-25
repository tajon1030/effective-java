## item52. 다중정의는 신중하게 사용하라

### 다중 정의 (Overroading)
예제코드 - CollectionClassifier

왜냐면 다중정의 (overloading)된 세 classify 중 어느 메서드를 호출할지는 **컴파일 타임**에 정해지기 때문이다.  
컴파일 타임에는 for 문 안의 c 는 항상 Collection\<?> 타입이다.  
런타임에는 매번 달라지지만, 호출할 다중정의 메서드를 선택할때는 영향을 주지 못한다.  
따라서 컴파일타임 기준으로 세 번째 메서드인 classify(Collection<?>) 만 호출하는 것이다.  

Why? -> **오버로딩(다중정의)한 메서드는 정적바인딩되기 때문.**  
그렇다면 오버라이딩은? 오버라이딩(재정의)한 메서드는 동적바인딩된다.  
이해를 위한 예제코드 - Overriding

오버라이딩을 했다면 해당 객체의 런타임타입이 어떤 메서드를 호룰할지의 기준이 된다.  
상위클래스가 정의한것과 똑같은 시그니처의 메서드를 하위클래스에서 오버라이딩한 다음, 그 하위클래스의 인스턴스에서 그 메서드를 호출하면 오버라이딩된 메서드가 실행된다.  
컴파일타임에 그 인스턴스 타입이 무엇이었냐는 상관이 없다.  
항상 **가장하위에서 오버라이딩한 메서드**가 실행되는것.  


-> 결과적으로 예제 CollectionClassifier 에서  
런타임에 기초해 값을 출력하도록 동작시키기위해서는  
모든 classify메서드를 하나로 합친후 instanceOf로 명시적으로 검사해서 사용해야 한다.  
~~~java
public static String classify(Collection<?> c) {
  return c instanceof Set ? "집합" :
          c instanceof List ? "리스트" : "그 외";
}
~~~

### 다중정의가 혼동을 일으키는 상황을 피하기
공개API의 경우라면 더더욱...  
사용자가 매개변수를 넘기면서 어떤 다중정의 메서드가 호출될지 모른다면 오동작하기 쉽다->문제진단 시간허비  
- 안전하고 보수적으로 가려면 매개변수 수가 같은 다중정의는 만들지 말자.  
- 가변인수(varargs)를 사용하는 메서드라면 다중정의를 아예 하지말자. (Item53 예외 기술-성능향상)  
- 다중정의 대신 메서드 이름을 다르게 지어주는 방법(java.io.ObjectOutputStream 의 writeBoolean, writeByte, writeShort, writeChar)  


### 생성자 다중정의
생성자는 이름을 다르게 지을수 없으므로 두번째 생성자부터는 무조건 다중정의가 될 수 밖에 없음  
but 정적팩터리라는 대안을 활용할 수 있음 + 생성자는 오버라이딩할 수 없으니 오버로딩과 오버라이딩이 혼용될 걱정을 하지않아도 되므로 걱정할일이 없음  

여러 생성자가 같은 수의 매개변수를 받아야하는 경우의 안전대책?  
-> 매개변수가 같은 다중정의를 피하는 이유는 결국 어떤 오버로딩된 메서드를 실행시킬지 혼란을 줘서 그런것 -> 근본적으로 다른 매개변수를 사용한다면 헷갈일 일이 없음  
ex) ArrayList에는 int를 받는 생성자와 Collection을 받는 생성자가 있는데  
int와 Collection은 근본적으로 다르기때문에 어떤 상황에서든 두 생성자 중 어느것이 호출되지는 헷갈릴 일이 없다.  

### 근본적으로 다르다?
java4 까지는 모든 기본타입이 참조타입과 근본적으로 달랐지만,  
#### java5 오토박싱이 도입되면서 그렇지 않게 되었다.

취약해진 예제 - SetList

set.remove(i)의 시그니처는 set.remove(Object)로 해당 Object를 제거함  
list.remove(i)는 다중정의된 remove(int index)를 선택하기때문  
따라서 i인수를 Integer로 형변환하면 원하는대로 동작시킬 수 있다.  
자바언어에 제네릭과 오토박싱을 더한 결과 List 인터페이스가 취약해졌다.  

#### 자바8에서 도입한 람다와 메서드 참조 역시 다중정의시의 혼란을 키웠다.  
~~~java
// 컴파일오류
ExecutorService exec = Executors.newCachedThreadPool();
exec.submit(System.out::println);
~~~
원인은 바로 submit 메서드는 다중정의되어있고 그중에는 Callable<T>를 받는 메서드도 있다는 데 있다.  
~~~java
<T> Future<T> submit(Callable<T> task);
Future<?> submit(Runnable task);
~~~
모든 println이 void를 반환하니, 반환값이 있는 Callable과 헷갈릴 리는 없다고 생각할 수도 있으나,  
참조된 메서드(println)과 호출한 메서드(submit)이 양쪽 다 다중정의되어있기때문에 애초부터 적절한 다중정의 메서드를 찾는 알고리즘이 기대처럼 동작하지 않는것.  
~~암시적 람다타입이나 부정확한메서드참조(System.out::println)같은 인수표현식은 목표타입이 선택되기전에는 그 의미가 정해지지않기때문에 적용성 테스트때 무시된다는 것이 원인~~  
핵심은 다중정의된 메서드(or생성자)들이 함수형 인터페이스를 인수로 받을때, 비록 서로 다른 함수형 인터페이스라도 인수위치가 같으면 혼란이 생긴다.  
-> **서로다른 함수형 인터페이스라도 같은 위치의 인수로 받아서는 안된다.**

#### Object외의 클래스 타입과 배열타입은 근본적으로 다르다.  
#### Serializable과 Colneable외의 인터페이스타입과 배열타입도 근본적으로 다르다.  
#### String과 Throwable처럼 상위/하위 관계가 아닌 두 클래스는 관련없다.  
#### 관련없는 클래스들끼리도 근본적으로 다르다.  

=> 다중정의된 메서드 중 하나를 선택하는 규칙은 이처럼 매우 복잡하며,  
자바가 버전업될수록 더욱 복잡해지고있어 이 모두를 이해하고 사용하는 프로그래머는 드물다.  
따라서 다중정의 사용을 조심해야함


### 이번 item의 정신을 지키는데 실패한 예
- String클래스의 contentEquals  
: 자바4시절부터 가지고있는 contentEquals(StringBuffer)메서드가 있었으나,  
자바5에서 String, StringBuffer, StringBuilder, CharBuffer 등의 비슷한 부류 타입을 위한 공통인터페이스로 CharSequence가 등장했고  
자연스럽게 String에도 CharSequence를 받는 contentEquals가 다중정의됨  
다행스럽게도 CharSequence를 받는 contentEquals는 기존 contentEquals와 동일한 기능을 수행한다.  

- String클래스의 valueOf(char[]) 와 valueOf(Object)  
: 같은 객체를 건네더라도 전혀 다른 일을 수행



## 추가내용 - 오토박싱
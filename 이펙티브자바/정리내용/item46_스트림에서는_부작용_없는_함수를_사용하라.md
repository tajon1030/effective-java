## item46. 스트림에서는 부작용 없는 함수를 사용하라

### 핵심정리
스트림뿐 아니라 스트림 관련 객체에 건네지는 모든 함수객체가 부작용(sideEffect)이 없어야 한다.  
종단 연산 forEach는 스트림이 수행한 계산결과를 보고할때(print)만 이용해야 하고, 계산자체에는 이용하지 말자.  
스트림을 올바로 사용하려면 수집기(collector)를 잘 알아둬야한다.

### 스트림
- 패러다임의 핵심 : 계산을 일련의 변환으로 재구성하는 부분
- 각 변환단계는 이전단계의 결과를 받아 처리하는 **순수함수**여야한다.
- 순수함수란? : 오직 입력만이 결과에 영향을 주는 함수  
  다른 가변상태를 참조하지않고, 함수 스스로도 다른 상태를 변경하지 않는 함수

### 문제코드 - 텍스트파일에서 단어별 수를 세어 빈도표로 만드는 코드
~~~java  
Map<String, Long> freq = new HashMap<>();
try(Stream<String> words = new Scanner(file).tokens()){
    words.forEach(word -> {
        freq.merge(word.toLowerCase(), 1L, Long::sum);
    })
}
~~~
결과는 올바르지만 스트림코드를 가장한 반복적 코드로,  
스트림API의 이점을 살리지 못하고 같은 기능의 반복적 코드보다 길고, 읽기어렵고, 유지보수에도 좋지않다는 단점  
종단연산 forEach에서 외부상태(빈도표 freq)를 수정하는 람다를 실행하며 문제가 생김  
forEach는 람다가 상태를 수정하는 등 연산결과를 보여주는 일 이상을 하는것은 나쁜 코드.  
**forEach연산은 스트림 계산결과를 보고할때만 사용하고, 계산할때는 쓰지말자**  
(그러나 가끔은 스트림 계산결과를 기존 컬렉션에 추가하는 등의 다른 용도로도 쓸수 있다.)  
-> 아예안되는건 아니지만..최대한 피하자는 의미  
1. 목적이 종단연산 목적. 종료조건이 있는 로직이 있어도 모두 검사하기때문에 for-loop랑 다름  
2. 멀티스레드에서 안전하지 않음  
   https://tecoble.techcourse.co.kr/post/2020-09-30-collection-stream-for-each/

### 제대로 된 코드
~~~java  
Map<String, Long> freq;
try(Stream<String> words = new Scanner(file).tokens()){
    freq = words
        .collect(groupingBy(String::toLowerCase, counting()));    
}
~~~


### 수집기 collector
수집기가 생성하는 객체는 일반적으로 Collection  
수집기를 사용하면 스트림원소를 손쉽게 컬렉션으로 모을 수 있다.  
https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Collectors.html  

#### toList
모든 스트림 요소를 List 인스턴스로 수집

#### toSet
모든 스트림 요소를 Set 인스턴스로 수집

#### toCollection
toList, toSet의 경우 특정 List,Set 구현체를 지정할수 없지만 toCollection 으로는 구현이 가능

#### toMap
모든 스트림요소를 Map 인스턴스로 수집  
스트림의 각 원소가 고유한 키에 매핑되어 있을 때 적합하다.
- toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)  
  : toMap(keyMapper, valueMapper) : 스트림 원소를 키에 매핑하는 함수와 값에 매핑하는 함수를 인수로 받는다.
~~~java  
// toMap 수집기를 사용하여 문자열을 열거 타입 상수에 매핑한다.
private static final Map<String, Operation> stringToEnum =
    Stream.of(values()).collect(
        toMap(Obejct::toString, e->e));
~~~  
중복 key발생시 IllegalStateException 을 던지며 종료된다.

- toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator\<U\> mergeFunction)  
  : BinaryOperator로 충돌시 처리방법을 지정할 수 있다.
~~~java  
// 마지막에 쓴 값을 취하는 수집기
toMap(keyMapper, valueMapper, (oldVal, newVal) -> newVal);

// 앨범 스트림을 맵으로 바꾸는데, 이 맵은 각 음악가와 그 음악가의 베스트 앨범을 짝지은 것
Map<Artist, Album> topHits = albums.collect(
        toMap(Album::artist, a->a, maxBy(comparing(Album::sales))));
~~~

- toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator\<U\> mergeFunction, Supplier<M> mapFactory)  
  : 맵 팩터리를 네 번째 인수로 넣어 EnumMap이나 TreeMap처럼 원하는 특정 맵 구현체를 직접 지정 가능
~~~java  
Stream<String> s = Stream.of("apple", "banana", "apricot", "orange", "apple");
LinkedHashMap<Character, String> m = s.collect(
           Collectors.toMap(s1 -> s1.charAt(0), s1 -> s1, (s1, s2) -> s1 + "|" + s2, LinkedHashMap::new));
~~~

#### groupinbBy
일부 속성별 객체를 그룹화하고 결과를 Map인스턴스에 저장하는데 사용

### joining
요소를 결합하는데 사용  
이 메서드는 (문자열 등의) CharSequence 인스턴스의 스트림에만 적용할 수 있다.
- joining() : 단순히 원소들을 연결(concatenate)하는 수집기를 반환한다.
- joining(CharSequence delimiter) : CharSequence 타입의 구분문자(delimiter)를 매개변수로 받는다.
- joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) : 접두접미문자 추가
~~~java  
String listToString = productList.stream()
  .map(Product::getName)
  .collect(Collectors.joining(", ", "<", ">"));
// <potatoes, orange, lemon, bread, sugar>
~~~


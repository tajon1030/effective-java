## item70. 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라

### 책 내용
복구할 수 있는 상황이면 checked exception을, 프로그래밍 오류라면 unchecked exception을 던지자.  
확실하지 않다면 unchecked exception을 던지자.  
checked exception도 아니고 런타임에러도 아닌 throwable은 정의하지도 말자.  
checked exception이라면 복구에 필요한 정보를 알려주는 메서드도 제공하자.  


### Spring Framework  
스프링 Transactional은 checked exception은 에러로 잡지 않는다.  
스프링 프레임워크의 트랜잭션 인프라 코드는 오직 런타임에서 발생하는 unchecked 예외에서만 롤백마크를 찍기때문에  
Checked Exception는 롤백을 발생시키지 않는다.  
Checked Exception는 수동으로 설정을 해줘야지 롤백으로 만들 수 있다.  

-> Checked Exception을 Unckecekd Exception으로 던지도록 하여  
메서드를 사용하는 곳에서는 아무런 예외처리를 진행하지 않도록 한다.  
~~~java
public <T> T readValue(String json, Class<T> clazz) {
	try {
		return objectMapper.readValue(json, clazz);
	} catch (IOException e) {
		throw new JsonDeserializeFailed(e.getMessage());
	}
}
~~~
~~~java
@Test
public void readValueTest(){
   String json = "{\"name\":\"nam\"}";
   Member member = objectMapperUtil.readValue(json, Member.class);
}
~~~


### Checked Exception은 필요하지 않다.  
Runtime Exception랑 Checked Exception는 기능적으로 동일하다.  
Checked exception을 반대하는 의견의 큰 주장은 대부분의 예외는 복원할 수 없다는 점.  
무책임하게 상위 메서드로 throw를 던지는 행위는 상위 메서드들의 책임이 그만큼 증가한다.  


### Clean Code - 7장 오류 처리 (미확인(uncheked) 예외를 사용하라)
로버트 C. 마틴의 클린코드 내용과 같이 이 논쟁은 checked exception을 사용하지 않자는 결론으로 일단락되었습니다.  



### 참고
https://velog.io/@eastperson/Java의-Checked-Exception은-실수다-83omm70j  
https://ttl-blog.tistory.com/351  
https://prodo-developer.tistory.com/149
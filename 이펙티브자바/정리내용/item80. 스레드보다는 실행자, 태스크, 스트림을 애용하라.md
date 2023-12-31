# 아이템 80: 스레드보다는 실행자, 태스크, 스트림을 애용하라

## Java Executor Framework
과거에는 단순한 작업 큐(work queue)를 만들기 위해서 수많은 코드를 작성해야 했지만,  
이제는 java.util.concurrent 패키지의 실행자 프레임워크(Executor Framework)를 이용하여 간단하게 작업 큐를 생성할 수 있습니다.  

~~~java
// 정적 팩터리들을 이용한 큐의 생성
ExecutorService exec = Executors.newSingleThreadExecutor(); 
// 태스크 실행
 exec.execute(runnable); 
// 실행자 종료 
exec.shutdown();
~~~

## Executor Framework의 동작방식  
Executor Framework는 스레드 풀을 사용하여 작업을 비동기식으로 실행합니다.  
작업이 실행자에게 제출되면 -> 실행자가 관리하는 대기열에 추가되고 -> 실행자가 대기열에서 작업을 선택하면 -> 스레드 풀에서 스레드에 할당하여 -> 스레드가 사용 가능해질때 작업이 진행됩니다.   


## Executor Framework의 구성  
앞에서 본 코드와 설명처럼 Executor Framework는 작업 단위와 실행 매커니즘이 분리됩니다.  
- 작업 단위=태스크  
: Runnale/Callable인터페이스 구현체  
(Callable은 값을 반환하고 임의의 예외를 던질 수 있다는 차이)   
- 실행 매커니즘 = 태스크를 수행  
: ExecutorService  


## Executor 인터페이스  
등록된 작업(Runnable)을 실행하기 위한 인터페이스
쓰레드풀에 작업 등록을하고 작업 실행을 해야하는데 이중에서 작업 실행만을 책임지는 역할을 합니다. 때문에 Executor인터페이스는 전달받은 작업(Runnable)을 실행하는 메소드만 가지고 있습니다.  


## ExecutorService  
ExecutorService는 작업(Runnable, Callable) 등록을 위한 인터페이스로  
Executor를 상속받아서 작업 등록 뿐만 아니라 실행을 위한 책임도 갖습니다. 그래서 쓰레드 풀은 기본적으로 ExecutorService 인터페이스를 구현합니다.  
그리고 이러한 역할을 수행하기위해서 ExecutorService는 Executor의 상태 확인과 작업 종료 등 라이프사이클 관리를 위한 메소드들(shutdown, shutdownNow,isShutdown,isTerminated,awaitTermination)과  
비동기 작업을 위한 메소드들을 가지고 있습니다.  

### 비동기작업을 위한 메소드들  
- submit  
: 실행할 작업들을 추가하고, 작업의 상태와 결과를 포함하는 Future를 반환  
- invokeAll  
: 모든 태스크가 완료될때까지 대기하여 각각의 상태와 결과를 갖는 List<Future>을 반환  
- invokeAny  
: 가장 빨리 실행된 결과가 나올 때 까지 대기하여 완료된 하나의 결과를 Future로 반환  

### ScheduledExecutorService  
ExecutorService를 상속받아서 태스크를 특정 시간에 혹은 주기적으로 실행하는 역할을 합니다.  


## ThreadPool 생성하기  
말했듯이 Executor Framework는 스레드 풀을 사용하여 작업을 비동기식으로 실행합니다.  
따라서 적절한 쓰레드풀을 사용할줄도 알아야합니다. 이때 직접 쓰레드를 다루는 것은 번거로우므로, 이를 도와주는 팩토리 클래스인 Executors을 사용해서 쓰레드풀을 만듭니다.  

- Executors.newCachedThreadPool()  
새로운 쓰레드가 필요한만큼만 동적 생성  
- Executors.newFixedThreadPool(int)  
고정된 사이즈의 쓰레드 풀 생성  
- newScheculedThreadPool()  
일정 시간 뒤 혹은 주기적으로 실행되어야 하는 작업을 위한 쓰레드 풀을 생성하며,   ScheduledThreadPoolExecutor 객체를 생성  
- newSingleThreadExecutor(), newSingleThreadScheduledExecutor()  
1개의 쓰레드만을 갖는 쓰레드 풀을 생성  


newCachedThreadPool는 무거운 프로덕션코드 적절치않습니다.  
CachedThreadPool은 요청받은 태스크들을 큐에 넣지 않고 즉시 스레드에 위임하는 방식으로 동작하는데,  
가용한 스레드가 없다면 즉시 스레드를 생성해서 동작하여 CPU 사용률이 100%일때에도 새로운 태스크가 도착하는 족족 새로운 스레드를 생성하여 상황이 악화될것이기 때문입니다.  
아니면 ThreadPoolExecutor 클래스를 사용하면 코어 및 최대 풀 크기를 설정을 할수있어 통제가 가능하기때문에 ThreadPoolExecutor클래스로 만든 스레드풀을 이용하면 무거운 프로덕션코드에도 적절할것입니다.  


## 스레드를 직접 다루지 말자  
심지어 자바 7부터 Executor Framework는 포크-조인(fork-join) 태스크를 지원하도록 확장됐습니다.  

ForkJoinTask의 인스턴스는 작은 하위 태스크로 나뉠 수 있고, ForkJoinPoll을 구성하는 스레드들이 이 태스크들을 처리하며, 일을 먼저 끝낸 스레드는 다른 스레드의 남은 태스크를 가져와 대신 처리할 수도 있습니다.  
따라서 모든 스레드가 최대한의 가용성을 뽑아낼 수 있게 되고 CPU를 최대한 활용해 높은 처리량과 낮은 지연시간을 가질 수 있게 됩니다.  

우리가 직접 스레드를 직접 작성하고 튜닝해서 이런성능을 뽑아내기란 어려운 일입니다. 대신 실행자 서비스를 실행하면 적은 노력으로 많은 이점을 누릴 수 있으므로 스레드보다는 실행자서비스를 애용합시다.  

## 참고
https://mangkyu.tistory.com/259  
https://wiki.yowu.dev/ko/Knowledge-base/Java/java-s-executor-framework-for-task-scheduling-and-execution  




##추가로 읽어볼것
https://engineerinsight.tistory.com/m/197  
https://headf1rst.github.io/TIL/spring-threadpool

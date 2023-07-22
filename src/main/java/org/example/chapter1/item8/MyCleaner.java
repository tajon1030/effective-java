package org.example.chapter1.item8;

import java.lang.ref.Cleaner;
import java.nio.ByteBuffer;

public class MyCleaner implements AutoCloseable {
    private static final Cleaner CLEANER = Cleaner.create();
    // 1. finalize() 메소드를 대체할 수 있는 Cleaner 클래스가 추가
    // > finalize() 메소드와는 달리 호출 시점이 보장되고 명시적으로 호출할 수 있기 때문에 더 안전하게 객체를 관리
    private final Resource resource = new Resource();
    private final Cleaner.Cleanable cleanable = CLEANER.register(this, resource);
    // 2. MyCleaner클래스 인스턴스 생성 시에 CLEANER.register(this, resource) 메소드를 사용하여 this와 resource 객체를 Cleaner에 등록
    public void doSomething() {
        this.resource.doSomething();
    }

    // close() 메소드를 호출하면 Cleaner를 통해 GC될떄 Resource 객체를 정리
    @Override
    public void close() throws Exception {
        this.cleanable.clean();
        // AutoCloseable 방식을 구현한 close() 메소드 내에서는 CLEANER의 clean() 메소드를 호출하여 resource 객체 정리
    }

    //  Resource 클래스는 Runnable를 구현한 것 객체를 정리할 때에 run() 메소드에서 해당 리소스에서 할당한 메모리 등을 정리

    private static class Resource implements Runnable {
        private final ByteBuffer buffer = ByteBuffer.allocate(1024);

        @Override
        public void run() {
            System.out.println("Resource 정리 됌");
        }

        public void doSomething() {
            // resource 사용
        }
    }
}
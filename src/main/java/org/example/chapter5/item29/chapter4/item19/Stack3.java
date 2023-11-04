package org.example.chapter5.item29.chapter4.item19;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack3<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 배열을 사용한 코드를 제네릭으로 만드는 방법 1
    // 배열 elements 는 push(E)로 넘어온 E 인스턴스만 담기때문에 타입 안전성을 보장하지만,
    // 이 배열의 런타임은 E[] 가 아닌 Object[]다
    @SuppressWarnings("unchecked")
    public Stack3() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];

        elements[size] = null; // 다쓴 참조 해제
        return result;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}

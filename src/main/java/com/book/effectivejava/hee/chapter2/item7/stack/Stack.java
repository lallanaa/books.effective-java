package com.book.effectivejava.hee.chapter2.item7.stack;
import java.util.Arrays;
import java.util.EmptyStackException;

// 코드 7-1 메모리 누수가 일어나는 위치는 어디인가? (p36)
public class Stack {
    private Object[] elements; // 메모리를 직접 관리하는 부분(특히 set, map, list 등의 collection)은 메모리 누수에 주의가 필요하다. 쌓였던 객체들의 생명주기가 언제 끝나는지를 염두해야 한다.
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() { elements = new Object[DEFAULT_INITIAL_CAPACITY]; }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 문제가 되는 소스
//    public Object pop() {
//        if (size == 0) {
//            throw new EmptyStackException();
//        }
//        return elements[--size];
//    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    // 코드 7-2 제대로 구현한 pop 메서드 (p37)
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제 -> null 을 넣어주어 명시적으로 참조를 해제한다.
        return result;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args) {
            stack.push(arg);
        }

        while (true) {
            System.out.println(stack.pop());
        }
    }
}

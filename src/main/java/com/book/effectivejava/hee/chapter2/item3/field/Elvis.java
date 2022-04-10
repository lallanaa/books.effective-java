package com.book.effectivejava.hee.chapter2.item3.field;

public class Elvis {
    // 만약 이 클래스에 implements Serializable 추가하는 순간 싱글턴 보장 X
    // readResolve() 메서드를 구현 + 역직렬화한 객체의 클래스가 readResolve 메서드 정의
    // -> 역직렬화 후 새로 생성된 객체를 인수로 이 메서드 호출........?
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {
        // private 으로 생성자를 선언함으로서, 외부에서 생성자를 통한 인스턴스화를 막는다.
        // 또한 이 생성자는 public static final FIELD 인 Elvis.INSTANCE 를 초기화할 때 '단 한 번 호출'됨.
        // 따라서, Elvis 클래스가 초기화될 때 만들어진 INSTANCE 가 전체 시스템 내에 하나임이 보장됨.

        // 예외) reflection API 인 AccessibleObject.setAccessible 을 사용하면 private 생성자 호출 가능.
        // 이 생성자 내에서 두 번째 객체가 생성되려할 때 예외를 던져 위의 상황을 막을 수 있다.
    }

    public void leaveTheBuilding() {

    }
}


package com.book.effectivejava.hee.chapter2.item3.staticFactory;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis(); // 정적 팩토리 : 새로운 객체를 생성하는 곳!?
    private Elvis() {}
    public static Elvis getInstance() { // 정적 팩토리 메소드 : 정적 팩토리를 리턴해주는 메소드?!
        return INSTANCE;
        // 항상 같은 객체의 참조를 반환한다.
        // -> 객체의 참조를 반환한다는 얘기는 new Elvis() 로 생성한 객체를 담은 INSTANCE 라는 이름의 final 변수를 반환한다는 얘기
    }
    public void leaveTheBuilding() {

    }

    // 해당 클래스에 Serializable 을 구현할 때 싱글턴이 깨짐. 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        // 역직렬화 시에 이 메서드가 호출 되고, '진짜' Elvis 반환 , 가짜 Elvis(역직렬화되면서 새로 생성된 객채) 는 가비지 컬렉터로 - ITEM89
        // 역직렬화 한 객체는 무시하고 클래스 초기화 때 만들어진 Elvis 인스턴스를 반환.
        // -> 따라서 Elvis 인스턴스의 직렬화 형태는 아무런 실 데이터를 가질 이유가 없으므로 모든 인스턴스 필드를 transient 선언....
        return INSTANCE;
    }
}

package com.book.effectivejava.hee.chapter2.item1;

public class HelloServiceFactory {

    // 정적 팩터리 메소드의 장점
    // 3. 인터페이스 타입(혹은 상속구조)을 사용하여 유연한 코드를 만들 수 있다.
    // return type 은 인터페이스로 선언하고, return 을 해주는 반환타입은 인스턴스는 이 인터페이스의 구현체이다.
    // return type 이 클래스이고, 실제 return 인스턴스는 return type 의 하위 클래스여도 된다.
    //  ∴ 인터페이스 기반의 프레임워크를 사용할 수 있게 해준다

    // JAVA8 이후에는 인터페이스에 static 메서드를 직접 입력 가능하므로,
    // 불필요한 클래스(정적팩터리메서드를 가진 팩터리클래스)의 생성을 줄이고 인터페이스에 직접 정적팩터리메소드 선언이 가능하다.

    /*public static HelloService of(String lang) {
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }*/

    public static void main(String[] args) {
        //HelloService ko = HelloServiceFactory.of("ko");
        HelloService eng = HelloService.of("eng");
        System.out.println(eng.hello());
        // 클라이언트 코드로부터 인터페이스 기반의 프레임워크를 사용하도록 강제할 수 있다.
        // 구체적인 타입을 클라이언트에게 숨길 수 있다.
    }
}

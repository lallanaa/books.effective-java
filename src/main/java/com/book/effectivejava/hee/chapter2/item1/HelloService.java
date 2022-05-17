package com.book.effectivejava.hee.chapter2.item1;

public interface HelloService {
    String hello();

    static HelloService of(String lang) { // 인터페이스에 접근제어자를 생략할 경우 public 으로 간주. (클래스에서는 패키지 레벨)
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }
    // JAVA8 이후에는 인터페이스에서 static 메서드의 선언이 가능해졌다!


    // 장점5 : 정적팩터리메서드를 작성하는 시점에 구현체가 없어도 된다.
    // if HelloService 인터페이스 내에 정적팩터리메서드가 구현되지 않았다면,
}

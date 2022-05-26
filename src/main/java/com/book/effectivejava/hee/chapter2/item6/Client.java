package com.book.effectivejava.hee.chapter2.item6;

public class Client {

    public static void main(String[] args) {
        //@Deprecated 의 forRemoval=true 속성을 주면 더욱 강력히 삭제될 예정임을 명시해준다. (Java9 부터)
        Deprecation deprecation = new Deprecation();
    }
}

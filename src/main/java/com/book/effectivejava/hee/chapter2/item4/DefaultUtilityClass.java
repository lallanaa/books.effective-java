package com.book.effectivejava.hee.chapter2.item4;

public class DefaultUtilityClass extends UtilityClass {

    public static void main(String[] args) {
        DefaultUtilityClass defaultUtilityClass = new DefaultUtilityClass();
        // 상위 클래스의 생성자가 호출되면서 "abstract class의 생성자가 호출된다!" 출력
    }

}

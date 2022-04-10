package com.book.effectivejava.yeon.chapter2;

public class MakeCoffee {
    public static void main(String[] args) {

        //Builder Pattern
        //@Builder 사용할 땐 new FooClass 한 적이 없었는데?
        new Coffee.Builder("Brazil", true)//Coffee 클래스의 이너 클래스 Builder를 생성!
                .moreWater(true)
                .syrup(true)
                .build();

        //lombok @Builder
        Coffee2.builder()
                .bean("Brazil")
                .water(true)
                .moreWater(true)
                .build();

        //Builder Pattern에 new FooClass.Builder()를 builder()로 감쌌음.
        //필수 매개변수는 없음
        Coffee3.builder()
                .bean("Brazil")
                .water(true)
                .build();

        //필수 매개변수는 있음
        Coffee3.builder("Brazil", true)
                .build();
    }
}

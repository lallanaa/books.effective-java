package com.book.effectivejava.hee.chapter2.item4;

public abstract class UtilityClass {

    public UtilityClass() {
        System.out.println("abstract class의 생성자가 호출된다!");
    }

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
//    private UtilityClass(){
//        throw new AssertionError(); -> try catch 로 처리해야 하는 게 아니라, 무조건 발생하면 안 되는 상황.
//    }

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        String hello = UtilityClass.hello(); // static method : 인스턴스를 만들지 않고 클래스에 접근하여 호출하는 메서드

        // static method 를 인스턴스에서 불러오는 것이 문법적으로 불가능하지 않다.
        // 그러나, 불러온 method 가 static method 인지, instance method 인지 헷갈리게 하므로 이렇게 사용하는 것을 권장하지 않는다
        /*UtilityClass utilityClass = new UtilityClass();
        utilityClass.hello();*/
        // 따라서 이와 같은 유틸성 클래스의 경우, instance 자체가 만들어지지 않도록 하는 것이 오히려 좋다



    }
}

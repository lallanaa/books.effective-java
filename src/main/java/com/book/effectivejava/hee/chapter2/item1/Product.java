package com.book.effectivejava.hee.chapter2.item1;

public class Product {

    public static void main(String[] args) {
        Settings settings1 = Settings.newInstance();
        Settings settings2 = Settings.newInstance();

        System.out.println(settings1);
        System.out.println(settings2);
//        com.book.effectivejava.hee.chapter2.item1.Settings@5e91993f
//        com.book.effectivejava.hee.chapter2.item1.Settings@5e91993f

        // newInstance()메서드를 통해 각기 다른 객체변수(인스턴스를 생성하는 것이 아닌, 생성된 인스턴스를 가져오는 기능)를 출력했을 때,
        // 동일한 해시코드가 출력됨 -> 동일한 인스턴스가 출력되었음을 알 수 있다.
        // 따라서, 생성자가 할 수 없는 인스턴스 통제에 대한 부분을 정적팩터리메서드를 통해 해결할 수 있음.

        Boolean.valueOf(true); //매개변수에 따라 각기 다른 인스턴스를 return 할 수도 있다.
        //    @HotSpotIntrinsicCandidate
        //    public static Boolean valueOf(boolean b) {
        //        return (b ? TRUE : FALSE);
        //    }

        //flyweight pattern
        //자주 사용하는 값들을 미리 캐싱하여 저장해두었다가 꺼내서 사용하는 방법.
        //정적팩터리메서드에서, 미리 만들어 둔 인스턴스를 return 하는 방식 등과 통용되는 부분이 있다!
    }
}

package com.book.effectivejava.hee.chapter2.item1;

public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    private Settings() {} // 생성자를 private 으로 선언하여 외부에서 객체를 생성하지 못하도록 통제. 클래스 안에서만 객체 생성 가능!

    // 객체를 생성하여 정적 상수로 저장.
    private static final Settings SETTINGS = new Settings();

    // newInstance 메서드로 생성한 객체를 return.
    // 외부에서 생성자에 접근할 수 없고, 아래의 메서드로만 객체를 생성할 수 있으므로 프로그램 내의 인스턴스가 하나로 통제됨.
    public static Settings newInstance() {
        return SETTINGS;
    }

    public static void main(String[] args) {
        System.out.println(new Settings());
        System.out.println(new Settings());
        System.out.println(new Settings());

        // toString() 메서드를 overriding 하지 않으면 각 인스턴스의 hashcode값을 출력하게 되는데,
        // 이 때의 hashcode가 모두 다르므로 각기 다른 객체가 생성되었음을 알 수 있다.
//        com.book.effectivejava.hee.chapter2.item1.Settings@3cb5cdba
//        com.book.effectivejava.hee.chapter2.item1.Settings@56cbfb61
//        com.book.effectivejava.hee.chapter2.item1.Settings@1134affc
    }

    // 정적 팩터리 메소드의 장점
    // 2. 정적 팩터리 메서드 내에서 생성되는 객체가 늘 새로 만들어질 필요가 없다???

    // 인스턴스를 새롭게 생성할 지, 생성된 인스턴스를 사용해야할 지, 인스턴스 생성에 대해 통제가 필요한 때가 있다.
    // 생성자를 통해 인스턴스를 만들면 통제가 불가능하다.
    // 싱글턴(Settings 객체에 대해 하나의 인스턴스만 존재하도록 통제)으로 객체를 생성하고자 할 때는 정적팩터리메서드를 고려할 수 있다.
}

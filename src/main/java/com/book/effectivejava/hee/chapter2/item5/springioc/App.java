package com.book.effectivejava.hee.chapter2.item5.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
//        SpellChecker spellChecker = new SpellChecker(); // new 를 통해 생성한 SpellChecker는 스프링이 모르는 객체
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class); // 스프링이 싱글톤으로 만들어 준 스프링 빈 객체, 의존성 주입
        spellChecker.isValid("test");
    }
}

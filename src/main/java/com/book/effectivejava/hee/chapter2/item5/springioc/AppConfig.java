package com.book.effectivejava.hee.chapter2.item5.springioc;


import com.book.effectivejava.hee.chapter2.item5.IDictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Spring 을 사용하기 위한 설정파일로서 자바 configuration 파일을 생성한다.
@Configuration
@ComponentScan(basePackageClasses = AppConfig.class) // 해당 클래스가 있는 패키지(springioc)로부터 컴포넌트를 찾아서 빈으로 등록해줌, 스캔의 범위를 최소화하여 필요한 만큼만 등록하는 것이 좋다.
public class AppConfig {

    @Bean
    public SpellChecker spellChecker(IDictionary dictionary) {
        return new SpellChecker(dictionary);
    }

    @Bean
    public IDictionary dictionary() {
        return new SpringDictionary();
    }
}

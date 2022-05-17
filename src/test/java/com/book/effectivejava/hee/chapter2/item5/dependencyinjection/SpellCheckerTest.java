package com.book.effectivejava.hee.chapter2.item5.dependencyinjection;

import com.book.effectivejava.hee.chapter2.item5.DefaultDictionary;
import com.book.effectivejava.hee.chapter2.item5.IDictionary;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isValid() {
        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
        //가짜 Dictionary를 사용하여 테스트가 가능하다.
        //SpellChecker의 외부에서 SpellChecker가 사용하는 리소스를 주입하여 변경이 가능.
        spellChecker.isValid("test");
    }

    @Test
    void isValid2() {
        // target type이 Supplier함수 인터페이스인 람다표현식.
        Supplier<IDictionary> dictionarySupplier = () -> new DefaultDictionary();
        SpellChecker spellChecker = new SpellChecker(dictionarySupplier);
//        reference 형식으로 작성한 동일 표현
        SpellChecker spellChecker1 = new SpellChecker(DefaultDictionary::new);

        //SpellChecker 생성자에 Supplier<DefaultDictionary> 를 받아오는 경우, IDictionary의 하위 클래스 MockDictionary를 생성 불가.
        SpellChecker spellChecker2 = new SpellChecker(MockDictionary::new);

        spellChecker.isValid("test");
    }

    @Test
    void isValid3() {
        SpellChecker spellChecker = new SpellChecker(() -> DictionaryFactory.get());
//        SpellChecker spellChecker = new SpellChecker(DictionaryFactory.get());  //static 한 method를 reference 형식으로 표현
        spellChecker.isValid("test");
    }
}
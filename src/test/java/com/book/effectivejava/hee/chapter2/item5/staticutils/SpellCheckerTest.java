package com.book.effectivejava.hee.chapter2.item5.staticutils;

import com.book.effectivejava.hee.chapter2.item5.DefaultDictionary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isValid() {
        assertTrue(SpellChecker.isValid("test"));
        //SpellChecker(static 메소드만으로 이루어진 Util성 클래스)
        //객체주입이 아닌 클래스 내에 자원을 직접 명시(new 생성자를 통해 클래스 내에서 자원의 인스턴스를 생성함)
        //테스트 코드를 사용할 떄, 직접 명시한 자원이 생성되므로 임의의 객체로 테스트가 불가능하다.
        //static한 메소드를 Mocking하는 것이 가능은 하지만 객체지향적으로 좋은 방법은 아니다.
    }

}
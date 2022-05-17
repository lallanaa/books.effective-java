package com.book.effectivejava.hee.chapter2.item5.staticutils;

import com.book.effectivejava.hee.chapter2.item5.DefaultDictionary;
import com.book.effectivejava.hee.chapter2.item5.Dictionary;
import com.book.effectivejava.hee.chapter2.item5.IDictionary;

import java.util.List;

public class SpellChecker {

    //SpellChecker 안의 Dictionary 는 영어사전, 국어사전, 기타 등등의 여러 가지의 사전의 기능이 올 수 있다.
    //즉, 사용하는 자원에 따라 동작이 달라진다.

    // 자원을 직접 명시하는 방법
    private static final IDictionary dictionary = new DefaultDictionary();

    private SpellChecker() {}

    // static 한 Utility 성 Class
    public static boolean isValid(String word) {
        // TODO SpellChecker 에서 쓰는 코드 (이 부분에 코드가 없으, dictionary 클래스를 직접 사용하는 것이 옳다)
        return dictionary.contains(word);
    }

    public static List<String> suggestion(String typo) {
        // TODO SpellChecker 에서 쓰는 코드
        return dictionary.closeWordsTo(typo);
    }
}

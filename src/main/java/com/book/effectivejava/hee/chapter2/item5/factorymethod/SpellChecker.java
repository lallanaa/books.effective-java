package com.book.effectivejava.hee.chapter2.item5.factorymethod;

import com.book.effectivejava.hee.chapter2.item5.Dictionary;
import com.book.effectivejava.hee.chapter2.item5.IDictionary;

import java.util.List;

public class SpellChecker {

    private IDictionary dictionary; // IDictionary => product interface

    public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.getDictionary();
        //추상적인 인터페이스 팩토리로 Dictionary 인터페이스를 가져옴
        //확장에 열려있고, 변경에는 닫혀있는 객체지향적인 상태가 된다.(OCP)
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestion(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}

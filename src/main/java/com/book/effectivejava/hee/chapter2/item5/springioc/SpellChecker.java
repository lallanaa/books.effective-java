package com.book.effectivejava.hee.chapter2.item5.springioc;

import com.book.effectivejava.hee.chapter2.item5.IDictionary;
import com.book.effectivejava.hee.chapter2.item5.factorymethod.DictionaryFactory;

import java.util.List;

//POJO (Plain Old Java Object) 객체 : Spring 은 제공하는 코드가 노출되지 않는다.
public class SpellChecker {

    private IDictionary dictionary;

    /*public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.getDictionary();
    }*/
    public SpellChecker(IDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestion(String typo) {
        return dictionary.closeWordsTo(typo);
    }
}

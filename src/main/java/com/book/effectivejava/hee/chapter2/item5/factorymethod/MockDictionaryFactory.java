package com.book.effectivejava.hee.chapter2.item5.factorymethod;

import com.book.effectivejava.hee.chapter2.item5.DefaultDictionary;
import com.book.effectivejava.hee.chapter2.item5.IDictionary;
import com.book.effectivejava.hee.chapter2.item5.dependencyinjection.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory {

    @Override
    public IDictionary getDictionary() {
        return new MockDictionary();
    }
}

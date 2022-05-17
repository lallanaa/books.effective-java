package com.book.effectivejava.hee.chapter2.item5.dependencyinjection;

import com.book.effectivejava.hee.chapter2.item5.IDictionary;

import java.util.List;

public class MockDictionary implements IDictionary {
    @Override
    public boolean contains(String word) {
        return false;
    }

    @Override
    public List<String> closeWordsTo(String typo) {
        return null;
    }
}

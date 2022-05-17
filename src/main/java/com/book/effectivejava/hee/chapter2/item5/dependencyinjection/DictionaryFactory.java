package com.book.effectivejava.hee.chapter2.item5.dependencyinjection;

import com.book.effectivejava.hee.chapter2.item5.DefaultDictionary;
import com.book.effectivejava.hee.chapter2.item5.Dictionary;
import com.book.effectivejava.hee.chapter2.item5.IDictionary;

public class DictionaryFactory {

//    public IDictionary get() {
//        return null;
//    }

    public static DefaultDictionary get() {
        return new DefaultDictionary();
    }
}

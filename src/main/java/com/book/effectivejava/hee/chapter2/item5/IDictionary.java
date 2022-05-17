package com.book.effectivejava.hee.chapter2.item5;

import java.util.List;

public interface IDictionary {

    boolean contains(String word);

    List<String> closeWordsTo(String typo);
}

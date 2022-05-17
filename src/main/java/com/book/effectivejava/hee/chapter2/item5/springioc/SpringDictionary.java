package com.book.effectivejava.hee.chapter2.item5.springioc;

import com.book.effectivejava.hee.chapter2.item5.IDictionary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringDictionary implements IDictionary {

    @Override
    public boolean contains(String word) {
        System.out.println("contains " + word);
        return false;
    }

    @Override
    public List<String> closeWordsTo(String typo) {
        return null;
    }
}

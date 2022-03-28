package com.book.effectivejava.kwangsu.chapter2.item1.money;

import com.book.effectivejava.kwangsu.chapter2.item1.money.Money;

public class Won implements Money {

    long amount;

    public Won(long amount) {
        this.amount = amount;
    }

    @Override
    public long getAmount() {
        return 0;
    }
}

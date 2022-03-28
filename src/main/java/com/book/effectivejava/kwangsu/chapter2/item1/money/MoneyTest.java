package com.book.effectivejava.kwangsu.chapter2.item1.money;


class MoneyTest {

    void test(){
        //인터페이스로 리턴받음
        Money d = Money.of(MoneyType.DOLLAR, 100);
        //d instanceof Dollar

        //인터페이스로 리턴받음
        Money w = Money.of(MoneyType.WON, 100);
        //d instanceof Won

        //인터페이스로 리턴받아서 메소드 하나로 처리 가능
        same(d, 100);
        same(w, 100);
    }

    //인터페이스로 받아서 처리
    boolean same(Money d, long b){
        return d.getAmount() == b;
    }
}
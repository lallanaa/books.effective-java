package com.book.effectivejava.hee.chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 추상클래스를 통한 "계층적 빌더"
 */
public abstract class Pizza {

    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    /* 공변 반환 타이핑(covariant return typing) :
     * 하위 클래스의 메서드가 상위 클래스의 메서드가 정의한 반환 타입이 아닌, 그 하위 타입을 반환하는 기능
     * 클라이언트가 형변환에 신경쓰지 않고 빌더를 사용할 수 있다.
     */
    abstract static class Builder<T extends Builder<T>> {  // 재귀적 타입 한정(item30)을 이용하는 제네릭 타입 !
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T andTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self(); // 추상메서드 self는 하위클래스에서 형변환 하지 않고 메서드체이닝을 지원할 수 있게 함.
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}


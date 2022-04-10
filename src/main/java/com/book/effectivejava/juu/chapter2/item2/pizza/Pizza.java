package com.book.effectivejava.juu.chapter2.item2.pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pizza {
	public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

	final Set<Topping> toppings;

	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping .class);

		//하위 클래스에서 공통으로 사용할 토핑
		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		// Pizza를 상속 받은 클래스(ex.NYPizza, Calzone) return
		// 메서드를 구현할 때 NYPizza 와 Calzone의 생성자를 호출하게 됨
		// ex) new NyPizza(this), new Calzone(this);
		abstract Pizza build();

		// 하위 클래스는 이 메서드를 재정의하고 this를 반환하도록 해야 한다.
		// @Override protected Builder self() { return this; }
		protected abstract T self();
	}

	// 저장된 토핑이 build()를 호출할 때 각각 생성자에서 super(builder)를 호출하고
	// super는 Pizza의 생성자이므로 아래의 Pizza가 호출되면서 토핑을 clone() 해서 저장한다.
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}

	@Override
	public String toString() {
		return toppings.stream().map(Enum::toString).collect(Collectors.joining(", "));
	}
}

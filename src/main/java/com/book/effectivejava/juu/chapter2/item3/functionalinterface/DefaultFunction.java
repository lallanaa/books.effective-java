package com.book.effectivejava.juu.chapter2.item3.functionalinterface;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.book.effectivejava.juu.chapter2.item3.methodrefference.Person;

//자바에서 기본으로 제공해주는 함수형 인터페이스는 무엇이 있는가?
public class DefaultFunction {
	public static void main(String[] args) {
		//input, output
		int i = Integer.parseInt("1");
		Function<Integer, String> intToString = Objects::toString;
		Supplier<Person> integerSupplier = Person::new;
		//Function<LocalDate, Person> personFunction = Person::new;
		Consumer<Integer> integerConsumer = System.out::println;
		//판별 boolean
		Predicate<Integer> integerPredicate;
	}
}

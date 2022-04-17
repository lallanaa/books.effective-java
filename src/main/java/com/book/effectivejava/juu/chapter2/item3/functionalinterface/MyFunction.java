package com.book.effectivejava.juu.chapter2.item3.functionalinterface;

@FunctionalInterface
public interface MyFunction {
	//메서드 선언은 오직 하나만 가져야 한다.(내용이 없는) 그러한 인터페이스만 functionalInterface만 붙일 수 있다.
	// 하나만 있을 경우 FunctionalInterface로 간주된다. -> annotation processor .. 찾아보기
	String valueOf(Integer integer);

	static String hello() {
		return "hello";
	}
}

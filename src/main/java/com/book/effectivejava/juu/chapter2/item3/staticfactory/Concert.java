package com.book.effectivejava.juu.chapter2.item3.staticfactory;

import java.util.function.Supplier;

//공급자로 사용할 수 있다
public class Concert {

	//공급자 : functuinalInterface -> supplier
	public void start(Supplier<Singer> singerSupplier) {
		Singer singer = singerSupplier.get();
		singer.sing();
	}

	public static void main(String[] args) {
		Concert concert = new Concert();
		concert.start(Elvis::getINSTANCE);
		//concert.start(Elvis.getINSTANCE());

		//익명내부클래스와 람다는 다르다
		//getINSTANCE()를 supplier로 사용할 수 있다.
	}
	/*
	public interface Supplier<T> {

	T get();
	인자 없는 메서드를 호출해서 무언가를 하나를 리턴해주는
	(이름은 중요하지 않음)
	-> public static Elvis getINSTANCE() {
		return INSTANCE;
	}
	}

	 */
}

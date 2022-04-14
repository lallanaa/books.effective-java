package com.book.effectivejava.juu.chapter2.item3;

import java.lang.reflect.Constructor;

public class ElvisReflection {

	public static void main(String[] args) {
		try {
			Constructor<Elvis> defaultConstructor = Elvis.class.getDeclaredConstructor();//접근지시자에 상관없이 private한 생성자에도 접근가능
			defaultConstructor.setAccessible(true);
			Elvis.INSTANCE.sing();
			Elvis elvis1 = defaultConstructor.newInstance();
			Elvis elvis2 = defaultConstructor.newInstance();
			System.out.println(elvis1 == elvis2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

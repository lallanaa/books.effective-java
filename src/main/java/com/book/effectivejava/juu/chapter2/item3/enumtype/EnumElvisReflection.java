package com.book.effectivejava.juu.chapter2.item3.enumtype;

import java.lang.reflect.Constructor;

public class EnumElvisReflection {
	public static void main(String[] args) {
		try {
			Constructor<Elvis> declaredConstructor = Elvis.class.getDeclaredConstructor();
			System.out.println("declaredConstructor = " + declaredConstructor);
			//실패! 에러!
			// enum은 태생적으로 new로 생성할 수 없음.
			// 리플렉션을 방지하기 위한 별도의 수단을 사용하지 않아도 됨
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}

package com.book.effectivejava.juu.chapter2.item3.enumtype;

import com.book.effectivejava.juu.chapter2.item3.field.IElvis;

// 열거 타입 방식의 싱글턴 - 바람직한 방법(25쪽)
// interface도 사용가능하기 때문에 테스트 문제도 깔끔하게 해결 가능
public enum Elvis implements IElvis {
	INSTANCE;

	public void leaveTheBuilding() {
		System.out.println("whoa baby, I'm outta here!");
	}

	@Override
	public void sing() {

	}

	//이 메서드는 보통 클래스 바깥(다른 클래스)에서 작성해야 한다.
	public static void main(String[] args) {
		//리플렉션과 직렬화 역직렬화에 매우 안전한 방법

		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}
}

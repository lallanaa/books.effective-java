package com.book.effectivejava.juu.chapter2.item3.staticfactory;

import java.util.function.Supplier;

public class Elvis implements Singer {
	private static final Elvis INSTANCE = new Elvis();
	private Elvis() {}

	public static Elvis getINSTANCE() {
		return INSTANCE;
		//return new Elvis(); //이렇게 바꾸면 클라이언트 코드는 바뀌지 않은 상태에서 새로운 인스턴스를 얻게 할 수 있다.
	}

	public void leaveTheBuilding() {
		System.out.println("whoa baby, I'm outta here!");
	}

	//이 메세드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
	public static void main(String[] args) {
		Elvis elvis = Elvis.getINSTANCE(); //매번 동일한 싱글턴 인스턴스를 가저온다
		elvis.leaveTheBuilding();

		//단점 : 테스트, 리플렉션, 직렬화 단점 동일
		//클라이언트코드 변경할 필요 없음.
		System.out.println(Elvis.getINSTANCE() == Elvis.getINSTANCE());
	}

	@Override
	public void sing() {
		System.out.println("my way~~~");
	}
}

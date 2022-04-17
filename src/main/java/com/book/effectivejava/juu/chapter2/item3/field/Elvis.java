package com.book.effectivejava.juu.chapter2.item3.field;

import java.io.Serializable;

public class Elvis implements  IElvis, Serializable { /*implements IElvis, Serializable {*/
	public static final Elvis INSTANCE = new Elvis();

	private static boolean created;


	private Elvis() {
		//reflection으로 생성 막음
		if (created) {
			throw new UnsupportedOperationException("can't be created by construcotr.");
		}
		created = true;
	}

	@Override
	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	@Override
	public void sing() {
		System.out.println("I'll have a blue~ Chrustmas without you~");
	}

	//override
	//싱글턴임을 보장해주는 readResolve 메서드
	private Object readResolve() {
		// 진짜 Elvis 를 반환하고, 가짜 Elvis는 GC 에 맡긴다
		return INSTANCE;
	}
}

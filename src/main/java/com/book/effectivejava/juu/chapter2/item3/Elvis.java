package com.book.effectivejava.juu.chapter2.item3;

public class Elvis implements IElvis{
	public static final Elvis INSTANCE = new Elvis();

	private Elvis() {}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	public void sing() {
		System.out.println("I'll have a blue~ Chrustmas without you~");
	}

}

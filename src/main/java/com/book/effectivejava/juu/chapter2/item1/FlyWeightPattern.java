package com.book.effectivejava.juu.chapter2.item1;

import java.util.Map;
import java.util.TreeMap;

public class FlyWeightPattern {
	public static void main(String[] args) {
		//flyWeightTest();
		stringTest();
	}

	private static void flyWeightTest() {
		FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
		FlyWeight flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println("flyWeight = " + flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println("flyWeight = " + flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("BB");
		System.out.println("flyWeight = " + flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println("flyWeight = " + flyWeight);
	}

	private static void stringTest() {
		String s1 = "hello";
		System.out.println(s1.hashCode());

		String s2 = "hello";
		System.out.println(s2.hashCode());

		//hello란 값이 들어가있는 곳의 주소는 동일
		//String이 불변하다는 것은 s1 = hello 에서 hi가 되면 s1이라는 변수가 갖는 참조값이 변하는 거지 hello가 가지고 있는 주소값이 변하는 것이 아니다.

		String s3 = new String("hi");
		System.out.println(s3.hashCode());
		String s4 = "hi";
		System.out.println(s4.hashCode());
	}
}

class FlyWeight {
	private String data;

	public FlyWeight(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
}


class FlyWeightFactory {
	private Map<String, FlyWeight> pool;

	public FlyWeightFactory() {
		this.pool = new TreeMap<>();
	}

	public FlyWeight getFlyWeight(String key) {
		FlyWeight flyWeight = pool.get(key);
		if (flyWeight != null && pool.containsKey(key)) {
			System.out.println("재 사용 = " + key.getClass().getName());
		} else {
			flyWeight = new FlyWeight(key);
			pool.put(key, flyWeight);
			System.out.println("새로 생성 = " + key.getClass().getName());
		}
		return flyWeight;
	}
}
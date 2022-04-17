package com.book.effectivejava.juu.chapter2.item3.staticfactory;

// 코드 3-2 제네릭 싱글톤 팩토리(24쪽)
public class MetaElvis<T> {
	private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

	private MetaElvis() {}

	@SuppressWarnings("unchecked")
	public static <E> MetaElvis<E> getInstance() {
		//싱글턴 인스턴스를 원하는 타입으로 변환해줌
		return (MetaElvis<E>)INSTANCE;
	}

	/*
	문제 : class 에 MetaElvis<T> t가 선언되어 있는데 왜
	public static "<T>1" MetaElvis<T>2 getInstance() 여기에도 t가 되어 있을까?
	-> 둘이 scope 가 다름
	위는 instance scope 이고
	아래는 staitc scope
	2는 1이랑 동일
	public static "<E>" MetaElvis<E> getInstance()
	 */

	public void say(T t) {
		//여기 t는 클래스의 t
		System.out.println(t);
	}

	public void leaveTheBuilding() {
		System.out.println("whoa baby, I'm outta here!");
	}

	public static void main(String[] args) {
		//인스턴스는 하나인데 [원하는 타입]으로 받을 수 있다 -> 제네릭 팩토리의 장점
		MetaElvis<String> elvis1 = MetaElvis.getInstance();
		MetaElvis<Object> elvis2 = MetaElvis.getInstance();
		MetaElvis<Integer> elvis3 = MetaElvis.getInstance();
		System.out.println(elvis1.equals(elvis3));
		//System.out.println(elvis1 == elvis2); 타입이 다르기 때문에 == 비교는 불가능. 타입이 다르면 다르다고 생각함
		elvis1.say("hello");
		elvis2.say(20000);

	}
}

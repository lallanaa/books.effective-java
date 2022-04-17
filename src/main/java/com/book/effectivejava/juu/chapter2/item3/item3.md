# 생성자나 열거 타입으로 싱글턴임을 보증하라

## 첫번째 방법 : private 생성자 + public static final 필드
```java
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	
	private Elvis(){}
}
```
* 장점 : 간결하고 싱글턴임을 API 에 드러낼 수 있다.
* 단점 1: 싱글톤을 사용하는 클라이언트를 테스트 하기 어려워진다. [[예제]](https://github.com/doremi-study/books.effective-java/tree/master/src/test/java/com/book/effectivejava/juu/chapter2/item3/ConsertTest.java)
* 단점 2: 리플렉션으로 private 생성자를 호출할 수 있다.[[예제]](https://github.com/doremi-study/books.effective-java/tree/master/src/main/java/com/book/effectivejava/juu/chapter2/item3/ElvisReflection.java)
* 단점 3: 역직렬화 할 때 새로운 인스턴스가 생길 수 있다.[[예제]](https://github.com/doremi-study/books.effective-java/tree/master/src/main/java/com/book/effectivejava/juu/chapter2/item3/ElvisSerialization.java)

## 두번째 방법 : private 생성자 + 정적 팩터리 메서드
* 장점 1 : API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
* 장점 2: 정적팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
* 장점 3: 정적 팩터리의 메서드 참조를 공급자(`Supplier`)로 사용할 수 있다.
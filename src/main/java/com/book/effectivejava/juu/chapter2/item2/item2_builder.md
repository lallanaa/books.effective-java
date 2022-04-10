### setter frezze
https://velog.io/@dhwlddjgmanf/JavaBeans-Pattern%EC%9D%B4-%EB%AD%90%EC%95%BC-lq9cyh9a

### 얕은 복사, 깊은 복사, 방어적 복사
https://velog.io/@miot2j/%EC%96%95%EC%9D%80%EB%B3%B5%EC%82%AC-%EA%B9%8A%EC%9D%80%EB%B3%B5%EC%82%AC-%EB%B0%A9%EC%96%B4%EC%A0%81-%EB%B3%B5%EC%82%AC%EB%9E%80

### 피자에 대한 깊은 설명..
https://debaeloper.tistory.com/35

### Lombok  `@Builder` 를 사용하면 왜 new 로 인스턴스를 생성하지 않을까?
effective java에서 builder 패턴 예시를 보면
```java
NyPizza nyPizza =  new NyPizza.Builder(NyPizza.Size.LARGE)
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.MUSHROOM)
			.addTopping(Pizza.Topping.ONION)
			.build();
```
`new`로 객체를 생성한다.
근데 평소에 내가 롬복으로 빌더를 생성해서 작성할 땐 `NyPizza nyPizza = Nypizza.builder` 로 사용했어서
`@Builder` 와 차이점이 뭔지 궁금했다.

lombok 코드가 생성해주는 builder 패턴을 참고해서 `NyPizza`를 다시 작성해보자.
[참고 블로그](https://velog.io/@park2348190/Lombok-Builder%EC%9D%98-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC)

>[NyPizzaLombok.java](https://github.com/doremi-study/books.effective-java/tree/master/src/main/java/com/book/effectivejava/juu/chapter2/item2/pizza/NyPizzaLombok.java)
```java
public class NyPizzaLombok extends Pizza {
	public enum Size {SMALL, MEDIUM, LARGE}

	private final Size size;

    public static NyPizzaLombok.NyPizzaLombokBuilder Builder(Size size) {
		return new NyPizzaLombok.NyPizzaLombokBuilder(size);
	}

	public static class NyPizzaLombokBuilder extends Pizza.Builder<NyPizzaLombokBuilder> {
		private final Size size;

		// NyPizza 는 size를 받는 생성자만 존재함
		public NyPizzaLombokBuilder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

        ....
	}
...
}	
```
`NyPizzaLombok` 클래스 안에 static *method*로 Builder를 생성하고 안에서 static *class*인 Builder 를 new 로 생성한다.
>[NyPizza.java](https://github.com/doremi-study/books.effective-java/tree/master/src/main/java/com/book/effectivejava/juu/chapter2/item2/pizza/NyPizza.java)
```java
public class NyPizza extends Pizza {
	public enum Size {SMALL, MEDIUM, LARGE}

	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;
		
        ...
	}
    ...
}
```
`NyPizza` class는 안에 바로 static class 가 있다.
그래서 `NyPizza`를 생성할 때 Builder 클래스를 생성해줘야되서 new 를 붙이는 거 같다. 😄 (아마도)
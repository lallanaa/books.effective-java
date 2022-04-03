#📀💿 Item1
# 정적 팩토리 메서드

<aside>
💡 인스턴스 생성 시 객체의 특성, 객체의 의미를 더 잘 보여줄 수 있다. 직관적으로

</aside>

하나의 시그니처로는 생성자를 하나만 만들 수 있다.

> 한 클래스에 시그니처가 같은 생성자가 여러 개 필요할 것 같으면,
생성자를 정적 팩토리 메서드로 바꾸고 각각의 차이를 잘 드러내는 이름을 지을 것.
>

## 정적 팩토리 메서드를 가진 Class

```java
public class Coffee {

	private String bean;
	private String water;

	private Coffee(String bean) {
		this.bean = bean;
	}

	private Coffee(String bean, String water) {
		this.bean = bean;
		this.water = water;
	}

	public static Coffee of(String bean) {
		return new Coffee(bean);
	}

	public static Coffee of(String bean, String water) {
		return new Coffee(bean, water);
	}
}
```

## 정적 팩토리 메서드로 인스턴스를 생성하는 Fatory Class

```java
public class CoffeeFactory {

	public static makeCoffee(boolean isEspresso, CoffeeIngredientDTO ingredient) {
		if (isEspresso) {
			return Coffee.of(ingredient.getBean());
		}
		return Coffee.of(ingredient.getBean(), ingredient.getWater());
	}
}
```

# 불필요한 객체 생성은 줄이자.

> 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
>

## 불변 클래스

- 인스턴스를 미리 만들어두거나
- 새로 생성한 인스턴스를 캐싱하여 재활용하는 식으로 객체 생성을 피할 수 있다.

## 구조 패턴을 사용해서 객체 생성을 줄이는 방법도 있다.

<aside>
💡 구조 패턴 Structural Pattern
작은 클래스들을 상속과 합성을 이용하여 더 큰 클래슬ㄹ 생성하는 방법을 제공하는 패턴이다.
컴파일 단계에서가 아닌 런타임 단계에서 복합 방법이나 대상을 변경할 수 있다는 점에서 유연성을 갖는다.

</aside>

### 예시

- Facade Pattern
- Adapter Pattern
- Decorator Pattern

### 런타임 시점에서 대상을 변경할 수 있다.

```java
public class Wage{

	public static createWage(boolean isProbation) {
		if (isProbation) {
			return ProbationWage.of();//수습 급여
		}
		return NormalWage.of();//일반 급여
	}
}
```

### Decorator Pattern

```java
public class Espresso() implements Coffee {

	//...

	public double make() {
		return machine + bean;
	}
}
```

```java
public class Americano() implements Coffee {
	
	public static Americano of(Coffee coffee) {
		this.coffee = coffee;
	}

	public double make() {
		return coffee.make() + water;
	}
}
```

```java
public class CoffeeFactory {

	public static Wage createCoffee(boolean isAmericano) {
		Espresso espresso = Espresso.of();
		if (isAmericano) {
			return Americano.of(espresso);
		}
		return espresso;
	}
}
```

## 박싱 클래스 설명이 기억에 남음

> 기본 타입은 boolean을 인자로 받아 Boolean 객체 참조로 변환하고 있다.
객체로!
>

# 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.

> 구현 클래스를 공개하지 않고도 그 객체를 반환할 수 있다.
>

## 궁금했던 것들 ⬇️

### 클래스를 공개하지 않는다.

접근 제어자가 public protected가 아니다.

접근제어자를 private, package-private으로 두고 다른 클래스에서 대신 생성해서 return하도록 하는 경우도 있다.

### api가 작다

어떤 로직을 A 클래스 내부에 숨겨두고 사용자는 로직 구현에 대한 고민없이 A 클래스의 메서드 호출하는 것만으로도 필요한 로직을 사용할 수 있다.

### 동반 클래스

해당 클래스와 관련된 유틸성 메서드를 모아놓은 클래스

- Array와 Arrays
- Collection과 Collections

# 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

Coffee가 있으면, Vanilla Latte 객체는 메뉴에 추가하기로 한 시점에 구현하면 된다는 의미인 것 같음
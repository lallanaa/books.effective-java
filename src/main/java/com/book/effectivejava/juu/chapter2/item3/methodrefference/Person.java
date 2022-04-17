package com.book.effectivejava.juu.chapter2.item3.methodrefference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import lombok.ToString;

@ToString
public class Person {
	LocalDate birthday;

	// public static int compareByAge(Person a, Person b) {
	// 	return a.birthday.compareTo(b.birthday);
	// }

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	// public int compareByAge(Person b) {
	// 	//임의의 객체에 대한 레퍼런스는 첫번째 객체가 자기 자신이 된다.
	// 	return this.birthday.compareTo(b.birthday);
	// }

	public Person() {
	}

	public Person(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return LocalDate.now().getYear() - birthday.getYear();
	}

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person(LocalDate.of(2013, 1, 28)));
		people.add(new Person(LocalDate.of(2011, 3, 2)));
		people.add(new Person(LocalDate.of(1982, 7, 15)));



		//Comparator 란 interface를 구현한 구현체
		// Comparator<Person> c = new Comparator<Person>() {
		// 	@Override
		// 	public int compare(Person a, Person b) {
		// 		return a.birthday.compareTo(b.birthday);
		// 	}
		// };
		// people.sort(c);
		//java 8 이전 사용방법
		// people.sort(new Comparator<Person>() {
		// 	@Override
		// 	public int compare(Person a, Person b) {
		// 		return a.birthday.compareTo(b.birthday);
		// 	}
		// });

		//java 8
		// people.sort((p1, p2) -> p1.birthday.compareTo(p2.birthday));
		// people.sort();
		//lambda expression에서 하는 일이 오로지 어떠한 메서드를 호출하는 일이라면 메서드 레퍼런스로 간추려서 쓸수가 있음
		//people.sort((p1, p2) -> Person.compareByAge(p1, p2));
		people.sort(Person::compareByAge);

		for (Person person : people) {
			System.out.println(person.toString());
		}


		//compare 인터페이스 -> 두개의 인자 하나의 리턴
		//sort는 compare 인터페이스의 메소드인데 compareByAge 이것도 두개의 인자 하나의 리턴이기 때문에 사용 가능능		people.sort(Person::compareByAge);

		//메서드 레퍼런스는 크게 4가지 쓸 수 있음
		//1. static 레퍼런스 ex Person::compareByAge
		//2. static이 없는 instance method를 참조하고 싶다면?
		// -> 참조할 수 없다. 인스턴스 메서드는 인스턴스를 통해서 접근해야 한다.
		//Person person = new Person(null);
		//people.sort(person::compareByAge);
		//3.굳이 인스턴스를 생성하고 싶지 않다면? -> 임의의 객체에 레퍼런스를 참조할 수 있다
		people.sort(Person::compareByAge);

		//4.생성자 객체 레퍼런스
		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.of(1982, 7, 15));
		dates.add(LocalDate.of(1982, 7, 15));
		dates.add(LocalDate.of(1982, 7, 15));
		//생성자 호출을 이렇게 바꿀 수 있음! 
		//List<Person> people2 = dates.stream().map(Person::new).collect(Collectors.toList());
		Function<LocalDate, Person> aNew = Person::new; //얘는 호환가능한 생성자는 Person(LocalDate birthday) 밖에 없음
		List<Person> people2 = dates.stream().map(aNew).collect(Collectors.toList());
		//근데 만약에 빈 생성자가 있다면?
		// Supplier<Person> integerSupplier = Person::new;
		// Function<LocalDate, Person> personFunction = Person::new;
	}

}

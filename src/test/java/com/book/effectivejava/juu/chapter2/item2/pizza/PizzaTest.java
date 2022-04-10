package com.book.effectivejava.juu.chapter2.item2.pizza;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.book.effectivejava.juu.chapter2.item2.pizza.Calzone;
import com.book.effectivejava.juu.chapter2.item2.pizza.NyPizza;
import com.book.effectivejava.juu.chapter2.item2.pizza.NyPizzaLombok;
import com.book.effectivejava.juu.chapter2.item2.pizza.Pizza;

class PizzaTest {

	@Test
	void name() {

		//given
		NyPizza nyPizza =  new NyPizza.Builder(NyPizza.Size.LARGE)
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.MUSHROOM)
			.addTopping(Pizza.Topping.ONION)
			.build();

		NyPizzaLombok build = NyPizzaLombok.Builder(NyPizzaLombok.Size.LARGE)
			.addTopping(Pizza.Topping.HAM)
			.addTopping(Pizza.Topping.MUSHROOM)
			.addTopping(Pizza.Topping.ONION)
			.build();

		Calzone calzone = new Calzone.Builder()
			.addTopping(Pizza.Topping.HAM)
			.sauceInside()
			.build();

		assertThat(nyPizza.toString()).isEqualTo("HAM, MUSHROOM, ONION");
		assertThat(calzone.toString()).isEqualTo("HAM");
	}
}
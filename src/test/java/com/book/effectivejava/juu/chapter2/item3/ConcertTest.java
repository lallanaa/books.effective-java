package com.book.effectivejava.juu.chapter2.item3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.book.effectivejava.juu.chapter2.item3.field.Concert;
import com.book.effectivejava.juu.chapter2.item3.field.Elvis;
import com.book.effectivejava.juu.chapter2.item3.field.MockElvis;

class ConcertTest {

	@Test
	void name() {
		//given
		// Concert concert = new Concert(new MockElvis());
		// concert.perform();
		Concert concert = new Concert(new MockElvis());
		concert.perform();

		//when
		assertThat(concert.isLightOn()).isTrue();
		assertThat(concert.isLightOn()).isTrue();
		//then
	}
}
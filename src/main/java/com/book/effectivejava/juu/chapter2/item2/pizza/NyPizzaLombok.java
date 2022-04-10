package com.book.effectivejava.juu.chapter2.item2.pizza;

import java.util.Objects;

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

		@Override
		NyPizzaLombok build() {
			return new NyPizzaLombok(this);
		}

		@Override
		protected NyPizzaLombokBuilder self() {
			return this;
		}
	}

	public NyPizzaLombok(NyPizzaLombokBuilder builder) {
		super(builder);
		this.size = builder.size;
	}
}

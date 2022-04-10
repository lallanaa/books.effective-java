package com.book.effectivejava.juu.chapter2.item2.pizza;

import java.util.Objects;

public class NyPizza extends Pizza {
	public enum Size {SMALL, MEDIUM, LARGE}

	private final Size size;

	public static class Builder extends Pizza.Builder<Builder> {
		private final Size size;

		// NyPizza 는 size를 받는 생성자만 존재함
		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		NyPizza build() {
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public NyPizza(Builder builder) {
		super(builder);
		this.size = builder.size;
	}
}

package com.book.effectivejava.juu.chapter2.item2.iphone;

public abstract class Iphone {

	private String color;
	private String volume;

	abstract static class Builder<T extends Iphone.Builder<T>> {
		private String color;
		private String volume;

		public T choiceColor(String color) {
			this.color = color;
			return self();
		}

		public T choiceVolume(String volume) {
			this.volume = volume;
			return self();
		}

		abstract Iphone build();

		protected abstract T self();
	}

	public Iphone(Iphone.Builder<?> builder) {
		this.color = builder.color;
		this.volume = builder.volume;
	}

	@Override
	public String toString() {
		return " {" +
			"color='" + color + '\'' +
			", volume='" + volume + '\'' +
			'}';
	}
}

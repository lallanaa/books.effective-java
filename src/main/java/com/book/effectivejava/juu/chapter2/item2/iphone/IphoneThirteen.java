package com.book.effectivejava.juu.chapter2.item2.iphone;

public class IphoneThirteen extends Iphone {
	public enum color {GREEN, PINK, BLUE, MIDNIGHT, STARTLIGHT, RED}
	public enum volume {GB128, GB256, GB512}
	public boolean isMini;

	public static class Builder extends Iphone.Builder<Builder> {

		private boolean isMini = false;

		public Builder mini() {
			isMini = true;
			return this;
		}

		@Override
		IphoneThirteen build() {
			return new IphoneThirteen(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public IphoneThirteen(Builder builder) {
		super(builder);
		this.isMini = builder.isMini;
	}

	@Override
	public String toString() {
		String className = this.getClass().getSimpleName();
		String iphone = super.toString();
		String iphoneThirteen = " option = " + "isMini " + isMini;
		return className + iphone + iphoneThirteen;
	}
}

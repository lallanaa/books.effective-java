package com.book.effectivejava.juu.chapter2.item2.iphone;

public class IphoneThirteenPro extends Iphone {
	public enum color {ALPINE_GREEN, SILVER, GOLD, GRAFITE, SIERRA_BLUE}
	public enum volume {GB128, GB256, GB512, TB1}

	private boolean isProMax;

	public static class Builder extends Iphone.Builder<Builder> {

		private boolean isMax = false;

		public Builder proMax() {
			isMax = true;
			return this;
		}

		@Override
		IphoneThirteenPro build() {
			return new IphoneThirteenPro(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	public IphoneThirteenPro(Builder builder) {
		super(builder);
		this.isProMax = builder.isMax;
	}

	@Override
	public String toString() {
		String className = this.getClass().getSimpleName();
		String iphone = super.toString();
		String iphoneThirteen = " option = " + "isProMax " + isProMax;
		return className + iphone + iphoneThirteen;
	}
}

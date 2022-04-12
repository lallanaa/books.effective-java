package com.book.effectivejava.juu.chapter2.item3;

public class Concert {
	private boolean lightOn;
	private boolean mainStateOpen;
	private IElvis elvis;

	public Concert(IElvis elvis) {
		this.elvis = elvis;
	}

	public void perform() {
		mainStateOpen = true;
		lightOn = true;
		elvis.sing();
	}

	public boolean isLightOn() {
		return lightOn;
	}

	public boolean isMainStateOpen() {
		return mainStateOpen;
	}
}

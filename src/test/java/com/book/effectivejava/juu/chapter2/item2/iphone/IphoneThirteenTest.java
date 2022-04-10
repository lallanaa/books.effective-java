package com.book.effectivejava.juu.chapter2.item2.iphone;

import org.junit.jupiter.api.Test;

class IphoneThirteenTest {

	@Test
	void name() {
		//given
		IphoneThirteenPro iphoneThirteenPro = new IphoneThirteenPro.Builder()
			.proMax()
			.choiceColor(IphoneThirteenPro.color.SILVER.toString())
			.choiceVolume(IphoneThirteenPro.volume.TB1.toString())
			.build();

		IphoneThirteen iphoneThirteen = new IphoneThirteen.Builder()
			.mini()
			.choiceColor(IphoneThirteen.color.PINK.toString())
			.choiceVolume(IphoneThirteen.volume.GB512.toString())
			.build();

		System.out.println("iphoneThirteenPro = " + iphoneThirteenPro.toString());
		System.out.println("iphoneThirteen = " + iphoneThirteen.toString());
		//when

		//then
	}
}
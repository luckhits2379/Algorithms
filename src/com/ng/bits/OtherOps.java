package com.ng.bits;

public class OtherOps {

	// ie. -1 and 5: true
	public boolean isOppositeSign(int a, int b) {

		return (a ^ b) < 0;
	}

	// ie. len = 3 > 111
	public int getBitMaskOf1(int len) {

		return (1 << len) - 1;
	}

	// If there is 1 set bit, means num is power of 2
	public boolean checkPowerOf2(int num) {

		return (num & (num - 1)) == 0;
	}

}

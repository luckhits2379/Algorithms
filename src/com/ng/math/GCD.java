package com.ng.math;

public class GCD {

	// Also called HCF (Highest common Factor)
	// Theorem: Any num which is divisior of a (bigger), b (smaller) is also divisor
	// of b and its remainder (b % a)
	// Time Complexity: log(min(a, b) -> base will be more than 2 so efficient
	// if passed smaller num first then it will auto adjust after one iteration

	// Euclidean algorithm (by repeated division) (mostly used)
	public static int euclideanGCDEfficient(int biggerNum, int SmallerNum) {

		if (SmallerNum == 0) {

			return biggerNum;
		}

		return euclideanGCDEfficient(SmallerNum, biggerNum % SmallerNum);
	}

	// Euclidean algorithm (by repeated subtraction)
	static int euclideanGCD(int biggerNum, int smallerNum) {

		if (smallerNum == 0) {

			return biggerNum;
		}

		return euclideanGCD(smallerNum, Math.abs(biggerNum - smallerNum));
	}

}

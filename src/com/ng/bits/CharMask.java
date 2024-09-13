package com.ng.bits;

public class CharMask {

	// In Many problems we need to check if character present or not or simillar use
	// case, for such cases we can create a char mask and use this mask to compare
	// with another string mask and using bit manipulation we can find the answer.
	// ie. mask for String abcdi will be 100001111
	public int countConsistentStrings(String allowed, String[] words) {

		int allowedMask = charMask(allowed);
		int res = 0;

		for (String word : words) {

			res += ((charMask(word) | allowedMask) == allowedMask) ? 1 : 0;
		}

		return res;
	}

	private int charMask(String s) {

		int mask = 0;

		for (int i = 0; i < s.length(); i++) {

			mask = mask | (1 << (s.charAt(i) - 'a')); // sets the bit for given char ie. sets 2nd bit from right for 'b'
		}

		return mask;
	}

}

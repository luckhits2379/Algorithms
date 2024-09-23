package com.ng.comparators;

import java.util.Arrays;

public class StringCustomComparator {

	public static void main(String[] args) {

		String s1 = "Nirmal";
		String s2 = "Gurjar";

		// compareTo method, compares character by character, as soon as it find
		// different characters it just returns it diff in ASCII value if diff is +ve
		// means s1 is bigger, if -ve means s2 is bigger if 0 means equal
		// if firt few characters matches then it checks length
		System.out.println(s1.compareTo(s2)); // check compareTo Method

	}

	// This problem using String custom comparator which compares string after
	// concatenation
	public String largestNumber(int[] nums) {

		String[] numStr = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {

			numStr[i] = String.valueOf(nums[i]);

		}

		// will give greatest string first
		Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));
		// if return is +ve means swap a1, a2 if return -ve / 0 means do nothing

		if (numStr[0].equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numStr.length; i++) {

			sb.append(numStr[i]);

		}

		return sb.toString();

	}
}

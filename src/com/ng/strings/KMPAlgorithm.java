package com.ng.strings;

import java.util.ArrayList;
import java.util.List;

// The Knuth-Morris-Pratt (KMP) algorithm is a string-searching algorithm used to find occurrences of a “pattern” 
// string within a “text” string efficiently. It was developed by Donald Knuth, Vaughan Pratt, and James H. Morris in 1977.
// The main advantage of the KMP algorithm is that it avoids redundant comparisons by preprocessing the pattern to 
// generate information that helps skip unnecessary comparisons during the search phase.

public class KMPAlgorithm {

	// Prefix Function (or Partial Match Table):

	// 1: The algorithm preprocesses the pattern to create a prefix function, also
	// known as the “longest proper prefix which is also a suffix” (LPS) array.
	// 2: For each position i in the pattern, the LPS array stores the length of the
	// longest proper prefix which is also a suffix for the substring ending at i.
	// 3: This table allows the algorithm to skip characters in the text by
	// determining how much of the pattern has already been matched.

	private int[] computeLPS(String pattern) {

		int patternLen = pattern.length();
		int[] logestPrefixSuffixArr = new int[patternLen];

		logestPrefixSuffixArr[0] = 0; // always, lps[0] = 0
		int patternIdx = 1;
		int matchingLen = 0;

		while (patternIdx < patternLen) {

			if (pattern.charAt(patternIdx) == pattern.charAt(matchingLen)) {

				matchingLen++;
				logestPrefixSuffixArr[patternIdx] = matchingLen;
				patternIdx++;

			} else {

				if (matchingLen != 0) {

					matchingLen--; // or matchingLen = lps[i - 1];

				} else {

					logestPrefixSuffixArr[patternIdx] = 0;
					patternIdx++;
				}

			}

		}

		return logestPrefixSuffixArr;

	}

	// Search Phase:

	// 1: The algorithm compares the pattern to the text. When a mismatch occurs,
	// instead of shifting the pattern by one character as in a brute force search,
	// the algorithm uses the LPS array to shift the pattern by the appropriate
	// amount. This allows the algorithm to skip over sections of the text without
	// rechecking characters that have already been matched.

	// TC: O(n + m)

	public List<Integer> kmpAlgorithm(String text, String pattern) {

		int patternLen = pattern.length();
		int textLen = text.length();

		List<Integer> matchingIdxList = new ArrayList<Integer>();

		if (patternLen > textLen) {

			return matchingIdxList; // return blank list
		}

		int[] logestPrefixSuffixArr = computeLPS(pattern);

		int textIdx = 0;
		int patternIdx = 0;

		while (textIdx < textLen) {

			if (pattern.charAt(patternIdx) == text.charAt(textIdx)) {

				patternIdx++;
				textIdx++;

				if (patternIdx == patternLen) { // if pattern fully matched

					matchingIdxList.add(textIdx - patternIdx);
					patternIdx = logestPrefixSuffixArr[patternIdx - 1];

				}

			} else {

				if (patternIdx != 0) {

					patternIdx = logestPrefixSuffixArr[patternIdx - 1];

				} else {

					textIdx++;
				}

			}

		}

		return matchingIdxList;

	}

}

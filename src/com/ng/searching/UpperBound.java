package com.ng.searching;

public class UpperBound {

	// Find the smallest index where num > target
	// Use cases:
	// Finding the position to insert an element in a sorted array while maintaining
	// the sorted order.
	// Counting the number of elements in a sorted array that are less than or equal
	// to a given value.
	// Finding the range of indices in a sorted array that contain a given value
	public int upperBound(int[] nums, int target) {

		int n = nums.length;

		int l = 0;
		int r = n - 1;
		int ans = n; // assume n is the index, if ans not found n will be returned

		while (l <= r) {

			int m = l + (r - l) / 2;

			// find smallest idx where num > target
			if (nums[m] > target) {

				ans = m;
				r = m - 1;

			} else {

				l = m + 1;
			}

		}

		return ans;

	}

}

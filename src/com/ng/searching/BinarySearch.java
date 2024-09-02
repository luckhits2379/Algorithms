package com.ng.searching;

public class BinarySearch {
	
	// Binary Search works on sorted data, with log(n) time complexity
	// Itertivaly narrows down the search space by half each time, hence log2 complexity
	public int binarySearch(int[] nums, int target) {

		int n = nums.length; // size of the array.
		int l = 0; 
		int r = n - 1;

		while (l <= r) {

			int m = l + (r - l) / 2;  // to handle integer overflow in using (l + r)/2

			if (nums[m] == target) {

				return m; // if match found, return this index

			} else if (target > nums[m]) // still greater target, narrow righ search space by moving l poiter to right

				l = m + 1;

			else { // target less than mid , narrow left search space by moving r poiter to left

				r = m - 1;
			}
		}

		return -1; // if match not found
	}

}

package com.ng.searching;

public class LowerBound {
	
	//Finds the smallest idx where num >= target
	//Use Case: Finding the position of an element
	public static int lowerBound(int[] nums, int target) {

		int n = nums.length;
		int l = 0;
		int r = n - 1;
		int ans = n; // assume n is the index, if ans not found n will be returned

		while (l <= r) {
			
			int m = l + (r - l) / 2;
			
			 //find smallest idx where num >= target
			if (nums[m] >= target) {
				
				ans = m;
				r = m - 1;
			
			} else {
				
				l = m + 1;
			}
		}

		return ans;
	}

}

package com.ng.others;

public class Heapify {

	// runs in O(n)
	public void buildHeap(int[] nums) {

		int n = nums.length;

		// we can also use i = n - 1 but n/2 nodes are leaf nodes to no need to run
		// so we can run this loop from n / 2 or precisely from n / 2 - 1 till 0 idx
		for (int i = n / 2 - 1; i > -1; i--) { // n = 2 * i + 2 > x = i = n / 2 - 2 / 2 = n / 2 - 1;

			heapify(nums, i);
		}

	}

	// runs in O(logn)
	public void heapify(int[] nums, int i) {

		int maxIdx = i;

		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < nums.length && nums[l] > nums[maxIdx]) {
			maxIdx = l;
		}

		if (r < nums.length && nums[r] > nums[maxIdx]) {
			maxIdx = r;
		}

		if (i != maxIdx) {

			// swap i and idx
			int temp = nums[maxIdx];
			nums[maxIdx] = nums[i];
			nums[i] = temp;

			heapify(nums, maxIdx);

		}

	}
}

package com.ng.sorting;

public class MergeSort {

	public static void main(String[] args) {

		int[] nums = new int[] { 12, 1, 2, 5, 3, 8, 23, 43, 1, 5, 7, 1 };
		mergeSort(0, nums.length - 1, nums);

		for (int num : nums) {
			System.out.println(num);
		}

	}

	public static void mergeSort(int s, int e, int[] nums) {

		if (s >= e) {
			return;
		}

		int m = (s + e) / 2;

		mergeSort(s, m, nums);
		mergeSort(m + 1, e, nums);

		merge(s, m, e, nums);

	}

	private static void merge(int s, int m, int e, int[] nums) {

		int len1 = m - s + 1;
		int len2 = e - m;

		int[] temp1 = new int[len1];
		int[] temp2 = new int[len2];

		int idx = 0;

		for (int i = s; i <= m; i++) {
			temp1[idx++] = nums[i];
		}

		idx = 0;

		for (int i = m + 1; i <= e; i++) {
			temp2[idx++] = nums[i];
		}

		int idx1 = 0;
		int idx2 = 0;

		for (int i = s; i <= e; i++) {

			if (idx1 < len1 && idx2 < len2) { // idx1, idx2 are in bound
				nums[i] = temp1[idx1] < temp2[idx2] ? temp1[idx1++] : temp2[idx2++];
				continue;
			}

			nums[i] = idx1 < len1 ? temp1[idx1++] : temp2[idx2++]; // anyone is in bound

		}

	}

}

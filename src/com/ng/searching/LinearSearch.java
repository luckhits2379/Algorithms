package com.ng.searching;

public class LinearSearch {

	public int search(int[] arr, int val) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == val) {
				
				return i;
			}
		}

		return -1;

	}
}

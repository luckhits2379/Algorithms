package com.ng.sorting;

//Adaptiveness: While bubble sort is not naturally adaptive, it can be modified with a flag that detects if a pass 
//completes without any swaps, allowing it to stop early if the array becomes sorted before all passes are completed.

//Stability: Bubble sort is a stable algorithm, meaning that equal elements retain their original order after sorting.

//Bubble sort is a simple, comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent 
//elements, and swaps them if they are in the wrong order. The process continues until no more swaps are needed, indicating that the list is sorted
//Means every pass it will sort the largest elemement, ie. 1st pass largest element will be placed last

//Best Case: O(1), Worst Case: O(n*n), Average: O(n*n), space: O(1)

//Due to its inefficiency, bubble sort is generally used only for educational purposes or in cases with very small datasets. Other algorithms, like insertion sort or selection sort, are often better choices for small datasets, 
//while algorithms like quicksort, mergesort, or heapsort are preferred for larger datasets

//Think like largest element is coming on the top like a bubble and hence called bubble sort

public class BubbleSort {

	public void sort(int[] nums) {

		int n = nums.length;

		boolean sorted = true; // flag to terminate early

		for (int i = 0; i < n - 1; i++) {

			sorted = true;

			for (int j = 0; j < n - 1 - i; j++) {

				if (nums[j] > nums[j + 1]) {

					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					sorted = false;
				}

			}

			if (sorted) { // no swaping was done means already sorted
				break;
			}

		}

	}

}

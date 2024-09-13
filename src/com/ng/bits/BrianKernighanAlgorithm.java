package com.ng.bits;

public class BrianKernighanAlgorithm {

	// Brian Kernighan’s algorithm provides an efficient way to count the number of
	// set bits (1s) in an integer by repeatedly eliminating the lowest set bit at
	// each step.
    
	//BrianKernighanAlgorithm
	//Time Complexity: O(num of set bits)
	public int getSetBitCountBKAlgo(int a) {

		int count = 0;

		while (a != 0) {

			a = a & (a - 1);
			count++;
		}

		return count;

	}

	
	//Time Complexity: O(bit length)
	public int getSetBitCount(int a) {

		int count = 0;

		while (a != 0) {
			
			count += (a & 1);
			a = a >> 1;
	
		}

		return count;

	}
	
	//if there is only 1 set bit means num is power of 2
	public boolean checkPowerOf2(int num) {
		
		return getSetBitCountBKAlgo(num) == 1;
	}
	
	
}

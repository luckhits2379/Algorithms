package com.ng.bits;

public class PrefixXor {

	// given queries, we need to find xor from-to, to better to precompoute prefix
	// xor, only take care of -1 index so we need to take n + 1 size prefix xor arr
	// xor from 4 to 5 will be prefixXor[6] ^ prefixXor[4], prefixXor[6] is storing
	// xor till 5 to handle edge cases

	public int[] xorQueries(int[] arr, int[][] queries) {

		int[] prefixXor = new int[arr.length + 1]; // xor till i will be stored at i - 1
		prefixXor[0] = 0; // initial xor will be 0. then start from index 1

		for (int i = 0; i < arr.length; i++) {

			prefixXor[i + 1] = arr[i] ^ prefixXor[i];
		}

		int[] res = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {

			int from = queries[i][0]; // + 1 - 1;
			int to = queries[i][1] + 1;

			res[i] = prefixXor[from] ^ prefixXor[to];
		}

		return res;

	}

}

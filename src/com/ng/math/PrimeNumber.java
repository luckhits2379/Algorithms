package com.ng.math;

import java.util.Arrays;

public class PrimeNumber {

	// The sieve of Eratosthenes is one of the most efficient ways to find all
	// primes smaller than n when n is smaller than 10 million or so.

	// run outer loop from 2 to sqrt of num, as inner loop starts from num * num
	// run inner loop from (num * num) as number before (num * num) were marked by
	// numbers before num
	// (ie. num = 4, 4 * 2 (done using 2 * 4), 4 * 3 (done using 3 * 4), so inner
	// loops starts from 4 * 4
	// time Complexity: nlog(logn)

	public boolean[] sieveOfEratosthenes(int n) {

		boolean prime[] = new boolean[n + 1];

		Arrays.fill(prime, true);

		prime[0] = prime[1] = false; // as 0, 1 are not prime

		for (int num = 2; num * num <= n; num++) {

			if (prime[num] == true) {

				for (int i = num * num; i <= n; i += num) {

					prime[i] = false;
				}
			}
		}

		return prime;

	}

	// Time complexity: O(n)
	static boolean isPrime(int n) {

		if (n <= 1) {
			
			return false;
		}

		// Check from 2 to n-1, one by one
		for (int i = 2; i < n; i++) {
			
			if (n % i == 0) {
				
				return false;
			}
		}
		
		return true;
	}

	// We need to check only till sqrt of n
	// ie. 36, divisiors are 2, 3, 4, 6, 9, 12, 18
	// So we need to check upto 6 only as 9, 12, 18 can be broken 18 * 2, 12 * 3, 9 * 4
	// Time complexity: O(√n)
	
	static boolean isPrimeEfficient(int n) {

		if (n <= 1) {

			return false;
		}

		for (int i = 2; i * i <= n; i++) {

			if (n % i == 0) {

				return false;
			}
		}

		return true;
	}
}

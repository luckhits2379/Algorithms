package com.ng.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DynamicProgrammingUsingTrie {

	// 2707. Extra Characters in a String
	// This problem can be solved in multiple ways, shown below, but using Trie is
	// most efficient, it checks if prefix of given string matches in trie till it
	// searches if not matched then break the loop, if end of word then call
	// function recusively.

	Trie root = new Trie();

	class Trie {

		Trie[] children = new Trie[26];
		boolean eow = false;
	}

	private void createTrie(String[] dict) {

		for (String word : dict) {

			Trie curr = root;

			for (int i = 0; i < word.length(); i++) {

				int c = word.charAt(i) - 'a';

				if (curr.children[c] == null) {

					curr.children[c] = new Trie();
				}

				curr = curr.children[c];
			}

			curr.eow = true;

		}

	}

	// Aproach 3 : using trie instead of set
	// TC : O(n * n)
	public int minExtraCharUsingTrie(String s, String[] dictionary) {

		createTrie(dictionary); // first populate the trie with given dictionary words

		return dfsTrie(0, s, new Integer[s.length()]);

	}

	public int dfsTrie(int idx, String s, Integer[] memo) {

		if (idx == s.length()) {

			return 0;
		}

		if (memo[idx] != null) {

			return memo[idx];
		}

		int res = 1 + dfsTrie(idx + 1, s, memo); // skip current char and keep looking other

		Trie curr = root;

		for (int i = idx; i < s.length(); i++) { // O(n)

			int c = s.charAt(i) - 'a';

			if (curr.children[c] == null) { // prefix not matched, no need to check further

				break;
			}

			curr = curr.children[c];

			if (curr.eow) { // if this prefix is also end of word

				res = Math.min(res, dfsTrie(i + 1, s, memo));
			}

		}

		return memo[idx] = res;

	}

	// Approach 2 : Using Bottom Up approach converted using approach 1
	// TC: O(n * n * n)
	public int minExtraCharUsingBottomUP(String s, String[] dictionary) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		Set<String> set = new HashSet();

		for (String str : dictionary) {
			set.add(str);
		}

		int n = s.length();
		int[] memo = new int[n + 1];
		Arrays.fill(memo, 51);
		memo[n] = 0;

		for (int idx = n - 1; idx >= 0; idx--) { // O(n)

			memo[idx] = 1 + memo[idx + 1]; // same as skip current char and keep looking other

			for (int i = idx; i < s.length(); i++) { // O(n)

				String word = s.substring(idx, i + 1); // O(n)

				if (set.contains(word)) {

					memo[idx] = Math.min(memo[idx], memo[i + 1]);

				}

			}

		}

		return memo[0];

	}

	// Approach 1: Using Top down approach
	// TC: O(n * n * n)
	public int minExtraCharTopDown(String s, String[] dictionary) {

		Integer[] memo = new Integer[s.length()];

		@SuppressWarnings({ "rawtypes", "unchecked" })
		Set<String> set = new HashSet();

		for (String str : dictionary) {
			set.add(str);
		}

		return dfsUsingTopDown(0, s, set, memo);

	}

	public int dfsUsingTopDown(int idx, String s, Set<String> set, Integer[] memo) {

		if (idx == s.length()) {
			return 0;
		}

		if (memo[idx] != null) {
			return memo[idx];
		}

		int currResult = 1 + dfsUsingTopDown(idx + 1, s, set, memo); // skip current char and keep looking other

		for (int i = idx; i < s.length(); i++) { // O(n)

			String word = s.substring(idx, i + 1); // O(n)

			if (set.contains(word)) {

				currResult = Math.min(currResult, dfsUsingTopDown(i + 1, s, set, memo));

			}

		}

		return memo[idx] = currResult;

	}
}

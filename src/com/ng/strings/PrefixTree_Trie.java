package com.ng.strings;

import java.util.HashMap;
import java.util.Map;

//2416. Sum of Prefix Scores of Strings
//Questions asks for count of each prefix, below is using Trie
//check hashmap and trie solution
public class PrefixTree_Trie {

	Trie root = new Trie();

	class Trie {

		Trie[] children = new Trie[26];

		int count = 0;
	}

	private void createTrie(String[] words) {

		for (String word : words) {

			Trie cur = root;

			for (int i = 0; i < word.length(); i++) {

				int idx = word.charAt(i) - 'a';

				if (cur.children[idx] == null) {
					cur.children[idx] = new Trie();
				}

				cur = cur.children[idx];
				cur.count++;

			}
		}

	}

	// Time Complexity: O( N * M)
	// N = words.length M = word avg length
	public int[] sumPrefixScores(String[] words) {

		createTrie(words);

		int[] ans = new int[words.length];

		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			Trie cur = root;

			for (int j = 0; j < word.length(); j++) {

				int idx = word.charAt(j) - 'a';
				cur = cur.children[idx];
				ans[i] += cur.count;

			}

		}

		return ans;
	}

	// Time Complexity: O( N * M * M)
	// N = words.length M = word avg length
	// In first you might think hashmap solution is also of O(N * M) but it is not,
	// its O(N* M * M) as toString() method will also have O(M) time complexity.
	// Using trie you can remove this time complexity of toString() method and
	// reduce to just O(N*M) solution
	public int[] sumPrefixScoresUsingHashMap(String[] words) {

		Map<String, Integer> countMap = new HashMap<String, Integer>();

		for (String word : words) {

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < word.length(); i++) {

				sb.append(word.charAt(i));
				String prefix = sb.toString();
				countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);

			}
		}

		int[] ans = new int[words.length];

		for (int i = 0; i < words.length; i++) { // O(N)

			String word = words[i];
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < word.length(); j++) { // O(M)

				sb.append(word.charAt(j));
				String prefix = sb.toString(); // O(M)
				ans[i] += countMap.get(prefix);

			}
		}

		return ans;
	}

}

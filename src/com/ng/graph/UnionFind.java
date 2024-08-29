package com.ng.graph;

public class UnionFind {
	
	//Normal find and union approach is inefficient and could lead to tree of length O(n) in worst case.
	//We can do optimization in 2 ways > 1: Union by Rank (Height of tree) / Size O(log n) 2 : Path Compression O(log n): 
	//The two techniques together -path compression with the union by rank/size, the time complexity will reach nearly constant time. 
	//It turns out, that the final amortized time complexity is O(α(n)) wherere α(n) is the inverse Ackermann. function . 
	//int[] parent for storing parents details and int[] rank for rank or int[] size for size for each ith element.

	class DisjointSetByRank {

		int[] parent = null;
		int[] rank = null;

		public DisjointSetByRank(int n) {

			parent = new int[n];
			rank = new int[n];

			for (int i = 0; i < n; i++) {

				parent[i] = i;
			}
		}

		public int find(int e) {

			if (parent[e] == e) {

				return e;
			}

			int g = find(parent[e]);
			parent[e] = g; // path compression

			return g;
		}

		public boolean union(int e1, int e2) {

			int g1 = find(e1); // group of element 1

			int g2 = find(e2); //group of element 2

			if (g1 == g2) {  //belongs to same group, no union required

				return false;
			}

			if (rank[g2] < rank[g1]) { // if rank of g2 is less than rank of g1

				parent[g2] = g1; // make g1 as parent of g2

			} else if (rank[g1] < rank[g2]) {

				parent[g1] = g2;

			} else { // equal

				parent[g1] = g2;
				rank[g2]++;
			}

			return true;
		}
	}

	class DisjointSetBySize {

		int[] parent = null;
		int[] size = null;

		public DisjointSetBySize(int n) {

			parent = new int[n];
			size = new int[n];

			for (int i = 0; i < n; i++) {

				parent[i] = i;
			}
		}

		public int find(int e) {

			if (parent[e] == e) {

				return e;
			}

			int g = find(parent[e]);
			parent[e] = g; //path compression

			return g;
		}

		public boolean union(int e1, int e2) {

			int g1 = find(e1);

			int g2 = find(e2);

			if (g1 == g2) { // same group, no union required

				return false;
			}

			if (size[g2] < size[g1]) { // if size of g1 is less than size of g2

				parent[g2] = g1; // make g1 as parent of g2
				size[g1] += size[g2]; // increase size of g1

			} else {

				parent[g1] = g2;
				size[g2] += size[g1];
			}

			return true;
		}
	}
}

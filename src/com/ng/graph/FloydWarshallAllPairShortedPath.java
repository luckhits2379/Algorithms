package com.ng.graph;

//Floyd Warshall's All Pair Shortest Path Algorithm. 
//No matter how many edges are there in the graph the Floyd Warshall Algorithm runs for O(V3) times 
//therefore it is best suited for Dense graphs.

//It works even when there are negative weights, as long as there are no negative cycles (cycles with a total weight less than zero).

//The Floyd-Warshall algorithm works based on the principle of dynamic programming to find the shortest paths between all pairs of vertices in a graph. 
//The recursive version of the algorithm leverages this principle by breaking the problem down into subproblems—each of which focuses on finding the shortest paths between vertices while considering an intermediate vertex (via)
public class FloydWarshallAllPairShortedPath {

	public void floydWarshallIteratively(int dist[][]) {

		int n = dist.length;

		for (int via = 0; via < n; via++) {

			// Pick all vertices as source one by one
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {

					if (dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE) {

						dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
					}
				}
			}
		}

	}

	public static void floydWarshallRecursive(int[][] dist, int via) {

		int n = dist.length;

		// Base case: stop when all vertices have been considered as intermediate
		// vertices
		if (via == n) {
			return;
		}

		// Update the distance matrix for all pairs (i, j)
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE) {

					dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
				}
			}
		}

		// Recur for the next intermediate vertex ( via + 1)
		floydWarshallRecursive(dist, via + 1);
	}
}

package com.ng.graph;

import java.util.Arrays;

public class BellmanFordSingleSourceShortestPath {

	// Relax n - 1 times
	// Works for directed graph and also for -ve edge but not with -ve cycle (infinite loop)
	// IMP: Works for undirected graph with no -ve edge as undirected graph with -ve edge will create -ve cycle after converting it to directed graph
	// Can detect -ve cycle as well
	// It works on DP principal

	//TC: E * V
	public int[] shortestDistanceforDirectedGraph(int[][] directedEdges, int totalNodes, int source) {

		int[] minDistanceArr = new int[totalNodes];
		Arrays.fill(minDistanceArr, Integer.MAX_VALUE);

		minDistanceArr[source] = 0;
		
		 //relax n - l times
		for(int i = 0; i < totalNodes - 1; i++) {

			boolean isRelaxed = false;

			for(int[] edge : directedEdges) {

				int u = edge[0];
				int v = edge[1];
				int w = edge[2];

				if(minDistanceArr[u] != Integer.MAX_VALUE && (w + minDistanceArr[u]) < minDistanceArr[v]) {

					isRelaxed = true;
					minDistanceArr[v] = w + minDistanceArr[u];

				}

			}

			if(!isRelaxed) { //If no further relaxation possible
				break;
			}

		}

		//detect cycle
		for(int[] edge : directedEdges) {

			int u = edge[0];
			int v = edge[1];
			int w = edge[2];

			if(minDistanceArr[u] != Integer.MAX_VALUE && (w + minDistanceArr[u]) < minDistanceArr[v]) {

				return null;

			}

		}


		return minDistanceArr;

	}

	//with no -ve edge
	public int[] shortestDistanceforUndirectedGraph(int[][] undirectedNonNegativeEdges, int totalNodes, int source) {

		int[] minDistanceArr = new int[totalNodes];
		Arrays.fill(minDistanceArr, Integer.MAX_VALUE);

		minDistanceArr[source] = 0;
		
		
         //relax n - l times
		for(int i = 0; i < totalNodes - 1; i++) {

			boolean isRelaxed = false;

			for(int[] edge : undirectedNonNegativeEdges) {

				int u = edge[0];
				int v = edge[1];
				int w = edge[2];
                
				//for edge u -> v
				if(minDistanceArr[u] != Integer.MAX_VALUE && (w + minDistanceArr[u]) < minDistanceArr[v]) {

					isRelaxed = true;
					minDistanceArr[v] = w + minDistanceArr[u];

				}
				
				
				//for edge v -> u
				if(minDistanceArr[v] != Integer.MAX_VALUE && (w + minDistanceArr[v]) < minDistanceArr[u]) {

					isRelaxed = true;
					minDistanceArr[u] = w + minDistanceArr[v];

				}

			}

			if(!isRelaxed) { // if no further relaxation possible
				break;
			}

		}

	
		return minDistanceArr;

	}
}

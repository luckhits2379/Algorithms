package com.ng.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstraSingleSourceShortestPath {


	//1: Works only for +ve edges, for -ve it may or may not give correct result.
	//2: Once a vertext is relaxed (visited), dont consider it, once relaxed means already at min distance.
	//3: Works with both directed / undirected, convert undirected to directed to work.
	//4: We can also use just queue but it will cost unnecessary iterations, hence not efficient.
	//5: We can use visited (relaxed) set but we will need to scan entire ans array to find min after each relaxation.
	//6: From point 5 and 6, we use PriorityQueue, as it gives min value in O(1), which is efficient.
	//7: There are variations of this algorithm, we need to take care in each step answer should not increase or ans should be bounded.
	//8: Works to find min distance as min distance is bounded while does not work with max distance as each iteration max distance will keep increasing hence not bounded.
	//9: Also works to find max probability (leetcode 1514) as max probablity is bounded and does not wotk with min probability as each iteration min probality will keep decreasing means not bounded.


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int[] getMinDistancePath(int[][] undirectedEdges, int totalNodes, int source, int distination) {       

		List<List<int[]>> adjList= new ArrayList();                                                         

		for(int i = 0; i < totalNodes; i++) {

			adjList.add(new LinkedList());
		}


		for(int[] edge:  undirectedEdges) {

			int u = edge[0];
			int v = edge[1];
			int w = edge[2];

			adjList.get(u).add(new int[] {v, w});
			adjList.get(v).add(new int[] {u, w});
		}

		//Distance Arr from source
		int[] distanceArrayfromSource = new int[totalNodes];                                                                                   
		Arrays.fill(distanceArrayfromSource, Integer.MAX_VALUE);  //initially max distance                                                  
		distanceArrayfromSource[source] = 0; //source to source distance 0                                                                                                                

		//Path Arr from source, to keep track from where we are coming at any node
		int[] pathArray = new int[totalNodes];                                                                               
		for(int i= 0; i < totalNodes; i++) {  
			pathArray[i] = i;                                                                
		}

		//mean heap
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);  
		pq.add(new int[]{source, 0});                                                                                       

		while(!pq.isEmpty()){                                                                                          

			int[] pair = pq.poll();                                                                                         
			int currNode = pair[0];
			int currNodeDistanceFromSource= pair[1];

			//Note: we can return ans from here as well if we found destination node, as it is relaxed now and no furthur better route is possible

			for(int[] adjacentNode: adjList.get(currNode)){                                                   

				int adjNode = adjacentNode[0];
				int adjDist = adjacentNode[1];

				int adjacentNodeDistanceFromSource = currNodeDistanceFromSource + adjDist;

				//if adjacentNodeDistanceFromSource is less than already computed distance
				if(adjacentNodeDistanceFromSource < distanceArrayfromSource[adjNode]){                                                            

					distanceArrayfromSource[adjNode] = adjacentNodeDistanceFromSource;                                                
					pq.add(new int[]{adjNode, adjacentNodeDistanceFromSource});           
					pathArray[adjNode] = currNode;  // to keep track we are coming from which node                                                  

				} 

			}

		}
		
		Stack<Integer> pathStack = new Stack();
		
		//before finding path, check if n - 1 is reachable
		if(distanceArrayfromSource[distination] != Integer.MAX_VALUE) {
			                                                                             
			int currNode = distination; //to find path from source to (n - 1)th node                                                                                                                    

			while(pathArray[currNode] != currNode){ 

				pathStack.push(currNode);
				currNode = pathArray[currNode];
			}

			if(currNode == source) {

				pathStack.push(source);  

			} else {

				System.out.println("Path not possible from source to n - 1 node");
				
				return new int[]{};
			}

		}
		
		int[] minPathArr = new int[pathStack.size()];
		
		int idx = 0;
		
		while(!pathStack.isEmpty()) {
			
			minPathArr[idx++] = pathStack.pop();
		}

		return minPathArr;  
	}
}

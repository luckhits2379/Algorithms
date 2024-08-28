package com.ng.matrix2d;

public class DFS {
	
	//Define 4 dirs left, right, up, down
	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	//Check if given row/ col is in bound
	public boolean isValid(int[][] grid, int r, int c) {

		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {

			return true;
		}

		return false;
	}
	
	
    //Sample fucntion which used DFS on 2-D matrix (Leetcode 1905)
	public int countSubIslands(int[][] grid1, int[][] grid2) {

		int row = grid2.length;
		int col = grid2[0].length;
		int res = 0;

		for (int r = 0; r < row; r++) {

			for (int c = 0; c < col; c++) {

				if (grid2[r][c] == 1 && dfs(grid2, grid1, r, c)) {

					res++;

				}
			}
		}

		return res;
	}
    
	//Function performing DFS on valid cell
	private boolean dfs(int[][] grid2, int[][] grid1, int r, int c) {

		if (!isValid(grid2, r, c) || grid2[r][c] == 0) {

			return true;
		}

		grid2[r][c] = 0;
		
		// if cell r,c in grid1 also contains 1
		boolean res = (grid1[r][c] == 1);

		for (int[] dir : dirs) {
            
			//funciton using res = dfs && res; as we need to run dfs on all adjacent cells and then return final result
			res = dfs(grid2, grid1, r + dir[0], c + dir[1]) && res;
			// we can also use res = res & dfs or res &= dfs;
			//if we used res = res && dfs(); we would have missed cells to visit
			//in some problem we can use res && dfs() to trim some iterations but be careful 
			//res = dfs && res is known as "short-circuit evaluation" to trim some iterations

		}

		return res;

	}

}

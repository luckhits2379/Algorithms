package com.ng.matrix2d;

public class DirAndValidFuctions {
	
	//Define 4 dirs left, right, up, down
	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	//Check if given row/ col is in bound
	public boolean isValid(int[][] grid, int r, int c) {

		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {

			return true;
		}

		return false;
	}
	
}

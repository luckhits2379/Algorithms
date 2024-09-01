package com.ng.matrix2d;

public class Convert1Dto2D {
	
	 // original arr is row order arr, break each chunk of row
	 public int[][] construct2DArray(int[] original, int row, int col) {
	        
	        int n = original.length;

	        if(n != (row * col)){

	            return new int[][]{};
	        }

	        int[][] res = new int[row][col];

	        for(int i = 0; i < n; i++){

	            int r = i / col;
	            int c = i % col;

	            res[r][c] = original[i];

	        }

	        return res;
	    }
}

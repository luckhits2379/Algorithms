package com.ng.matrix2d;

public class Convert2Dto1D {

	int totalRow = 0;
	int totalCol = 0;
	int n = 0;
	int[] arr = null;

	public Convert2Dto1D(int totalRow, int totalCol) {

		this.n = totalRow * totalCol;
		this.totalRow = totalRow;
		this.totalCol = totalCol;

		arr = new int[n];
	}

	// We need to decide whether the array elements will be stored in row order or
	// column order,
	// for row order you multiply the row index by the width, and add the column
	// index,
	// and column order would be (c * (len of col + r), also we can convert 1d to 2d
	// by devide / and modulo % with len of row or len of col, we can derive this
	// from earlier formula easily.

	public int rowOrderIdx(int r, int c) {

		return (r * totalCol) + c;
	}

	public int colOrderIdx(int r, int c) {

		return (c * totalRow) + r;
	}

}

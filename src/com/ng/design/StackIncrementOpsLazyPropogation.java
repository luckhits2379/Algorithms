package com.ng.design;

public class StackIncrementOpsLazyPropogation {

	// The basic idea is to avoid updating all elements of the data structure during
	// a range update immediately. Instead, updates are “lazy,” meaning the ds will
	// store pending updates at the nodes/index in additional memory and only
	// propagate them when necessary, like when querying or updating children
	// nodes/index. ie. 1381. Design a Stack With Increment Operation
}

//1381. Design a Stack With Increment Operation
class CustomStack {

	int[] stack = null;
	int[] offset = null;
	int size = 0;
	int maxSize = 0;

	public CustomStack(int maxSize) {

		this.maxSize = maxSize;
		stack = new int[maxSize];
		offset = new int[maxSize];

	}

	public void push(int x) {

		if (size == maxSize) {
			return;
		}

		stack[size++] = x;
	}

	public int pop() {

		if (size == 0) {
			return -1;
		}

		size--;

		int offsetVal = offset[size];

		if (size > 0) {
			offset[size - 1] += offsetVal;
		}

		offset[size] = 0;

		return stack[size] + offsetVal;
	}

	public void increment(int k, int val) {

		if (size == 0) {
			return;
		}

		if (k >= size) {
			k = size;
		}

		offset[k - 1] += val;
	}
}
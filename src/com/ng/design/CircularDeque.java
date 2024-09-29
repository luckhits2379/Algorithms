package com.ng.design;

//Design implementation of the circular double-ended queue (deque), leetcode 641
public class CircularDeque {

	int[] deque = null;
	int k = 0;
	int size = 0;
	int front = 0;
	int rear = 0;

	public CircularDeque(int k) {
		this.k = k;
		deque = new int[k];
	}

	public boolean insertFront(int value) {

		if (isFull()) {
			return false;
		}

		if (isEmpty()) {
			front = 0;
			rear = 0;
			deque[0] = value;
			size++;
			return true;
		}

		front = ((front + k) - 1) % k;
		deque[front] = value;
		size++;

		return true;

	}

	public boolean insertLast(int value) {

		if (isFull()) {
			return false;
		}

		if (isEmpty()) {
			front = 0;
			rear = 0;
			deque[0] = value;
			size++;
			return true;
		}

		rear = (rear + 1 + k) % k;
		deque[rear] = value;
		size++;

		return true;

	}

	public boolean deleteFront() {

		if (isEmpty()) {
			return false;
		}

		front = (front + 1 + k) % k;
		size--;

		return true;
	}

	public boolean deleteLast() {

		if (isEmpty()) {
			return false;
		}

		rear = (rear - 1 + k) % k;
		size--;

		return true;
	}

	public int getFront() {

		if (isEmpty()) {
			return -1;
		}

		return deque[front];

	}

	public int getRear() {

		if (isEmpty()) {
			return -1;
		}

		return deque[rear];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == k;
	}
}

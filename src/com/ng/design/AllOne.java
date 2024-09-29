package com.ng.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Design a data structure to store the strings' count with the ability to return the strings with 
//minimum and maximum counts with O(1) operation. leetcode 432
public class AllOne {

	Map<String, ListNode> map = null;
	ListNode dummyHead = null;
	ListNode dummyTail = null;

	class ListNode {

		boolean isDummy = false; // to handle operation on head or tail
		int count = 0;
		Set<String> keysSet = new HashSet<String>();
		ListNode next = null;
		ListNode prev = null;

		public void addKey(String key) {

			if (isDummy) { // if this dummy node means its either tail or head, any add / remove wont work
							// here
				return;
			}

			keysSet.add(key);
		}

		public void removeKey(String key) {

			if (isDummy) { // if this dummy node means its either tail or head, any add / remove wont work
							// here
				return;
			}

			keysSet.remove(key);
		}

	}

	public AllOne() {

		map = new HashMap<String, ListNode>();

		dummyHead = new ListNode();
		dummyHead.isDummy = true; // mark dummy

		dummyTail = new ListNode();
		dummyTail.isDummy = true; // mark dummy

		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	public void dec(String key) {

		ListNode cur = map.get(key);
		ListNode prev = cur.prev;

		// dont insert new Node
		if (prev.count == cur.count - 1) {// this will also work if prev is head with count == 0

			prev.addKey(key);
			cur.removeKey(key);
			map.put(key, prev);

		} else { // insert new node

			ListNode newNode = new ListNode();
			newNode.count = cur.count - 1;
			newNode.addKey(key);

			newNode.next = cur;
			cur.prev = newNode;

			prev.next = newNode;
			newNode.prev = prev;

			cur.removeKey(key);
			map.put(key, newNode);

		}

		removeNodeIfEmpty(cur);

		if (map.get(key).isDummy) { // if cur key is pointing to head means count == 0
			map.remove(key);
		}

	}

	public void inc(String key) {

		ListNode cur = dummyHead;

		if (map.containsKey(key)) {
			cur = map.get(key);
		}

		ListNode next = cur.next;

		// dont insert new Node
		if (next.count == cur.count + 1) { // this will also work if next node is tail

			next.addKey(key);
			cur.removeKey(key);
			map.put(key, next);

		} else { // insert new node

			ListNode newNode = new ListNode();
			newNode.count = cur.count + 1;
			newNode.addKey(key);

			newNode.next = next;
			next.prev = newNode;

			cur.next = newNode;
			newNode.prev = cur;

			cur.removeKey(key);
			map.put(key, newNode);

		}

		removeNodeIfEmpty(cur);

	}

	public String getMaxKey() {

		if (map.isEmpty()) {
			return "";
		}

		return dummyTail.prev.keysSet.iterator().next();
	}

	public String getMinKey() {

		if (map.isEmpty()) {
			return "";
		}

		return dummyHead.next.keysSet.iterator().next();
	}

	private void removeNodeIfEmpty(ListNode cur) {

		if (!cur.isDummy && cur.keysSet.isEmpty()) {

			ListNode prev = cur.prev;
			ListNode next = cur.next;
			prev.next = next;
			next.prev = prev;
		}

	}
}
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
		Set<String> set = new HashSet<String>();
		ListNode next = null;
		ListNode prev = null;

		public void add(String key) {

			if (isDummy) { // if this dummy node means its either tail or head, any add / remove wont work

				return;
			}

			set.add(key);
		}

		public void remove(String key) {

			if (isDummy) { // if this dummy node means its either tail or head, any add / remove wont work

				return;
			}

			set.remove(key);
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

			prev.add(key);
			cur.remove(key);
			map.put(key, prev);

		} else { // insert new node

			ListNode newNode = new ListNode();
			newNode.count = cur.count - 1;
			newNode.add(key);

			newNode.next = cur;
			cur.prev = newNode;

			prev.next = newNode;
			newNode.prev = prev;

			cur.remove(key);
			map.put(key, newNode);

		}

		if (cur.set.isEmpty()) { // remove this node

			ListNode prevTemp = cur.prev;
			ListNode next = cur.next;
			prevTemp.next = next;
			next.prev = prevTemp;
		}

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

			next.add(key);
			cur.remove(key);
			map.put(key, next);

		} else { // insert new node

			ListNode newNode = new ListNode();
			newNode.count = cur.count + 1;
			newNode.add(key);

			newNode.next = next;
			next.prev = newNode;

			cur.next = newNode;
			newNode.prev = cur;

			cur.remove(key);
			map.put(key, newNode);

		}

		if (!cur.isDummy && cur.set.isEmpty()) { // remove this node, if this is not head

			ListNode prevTemp = cur.prev;
			ListNode nextTemp = cur.next;
			prevTemp.next = nextTemp;
			nextTemp.prev = prevTemp;
		}

	}

	public String getMaxKey() {

		if (map.isEmpty()) {
			return "";
		}

		return dummyTail.prev.set.iterator().next();
	}

	public String getMinKey() {

		if (map.isEmpty()) {
			return "";
		}

		return dummyHead.next.set.iterator().next();
	}
}
package com.ng.linkedlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DummyNodeAndPrevPointer {
	
	
	//Below problem ask to modify a exsting linkedList whos node value in present in given nums array
    //We can use dummy node to handle edge cases (if head is null / to be removed) gracefully.
	//We can use prev pointer to handle a delete, as prev pointer used in reversing a linkedlist
	
	public ListNode modifiedList(int[] nums, ListNode head) {

		Set<Integer> set = Arrays.stream(nums).collect(HashSet::new, HashSet::add, HashSet::addAll);

		// dummy node technique to handle edge cases
		ListNode dummy = new ListNode();
		dummy.next = head;

		// maintains ref to prev node same as reversing a linkedlist
		ListNode prev = dummy;
		ListNode curr = head;

		while (curr != null) {

			// if set has matching element then just move curr pointer
			if (set.contains(curr.val)) { 

				curr = curr.next;  //moving curr
				prev.next = curr; // deleting curr node

			} else { // move both curr and prev pointers

				prev = curr;  //move prev
				curr = curr.next; // move curr
			}
		}

		return dummy.next;
	}

}

package google;

import datastructure.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean cycleExist = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				cycleExist = true;
				break;
			}
		}
		
		if (cycleExist == false) {
			return null;
		}
		
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
}

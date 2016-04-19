package google;

import datastructure.ListNode;

/*
 * http://www.geeksforgeeks.org/point-arbit-pointer-greatest-value-right-side-node-linked-list/
 * */
public class LinkedArbitaryPointer {
	public void link(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		
		head = reverse(head);
		ListNode greatest = head;
		ListNode cur = head.next;
		while (cur != null) {
			cur.random = greatest;
			if (cur.val > greatest.val) {
				greatest = cur;
			}
			cur = cur.next;
		}
		
		reverse(head);
	}
	
	public ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		return pre;
	}
}

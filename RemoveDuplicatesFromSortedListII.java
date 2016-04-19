package google;

import datastructure.ListNode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			while (next != null && next.val == node.val) {
				next = next.next;
			}
			
			if (next == node.next) {
				// no duplicate
				cur.next = node;
				cur = cur.next;
				cur.next = null; // break
			} 
			
			node = next;
		}
		
		return newHead.next;
	}
}

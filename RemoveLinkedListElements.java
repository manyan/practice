package google;

import datastructure.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		while (head != null) {
			if (head.val == val) {
				cur.next = null;
			} else {
				cur.next = head;
				cur = head;
			}
			
			head = head.next;
		}
		
		return newHead.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		RemoveLinkedListElements r = new RemoveLinkedListElements();
		r.removeElements(head, 2);
	}
}

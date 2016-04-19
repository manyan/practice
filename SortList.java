package google;

import datastructure.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode mid = findMid(head);
		ListNode second = mid.next;
		mid.next = null;
		
		head = sortList(head);
		second = sortList(second);
		
		// merge
		ListNode h = new ListNode(0);
		ListNode cur = h;
		while (head != null && second != null) {
			if (head.val <= second.val) {
				cur.next = head;
				head = head.next;
			} else {
				cur.next = second;
				second = second.next;
			}
			cur = cur.next;
		}
		
		if (head != null) {
			cur.next = head;
		}
		if (second != null) {
			cur.next = second;
		}
		
		return h.next;
	}
	
	public ListNode findMid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
}

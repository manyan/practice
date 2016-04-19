package google;

import datastructure.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		
		// step 1: break into 2 list from the middle
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode second = slow.next;
		slow.next = null;
		
		// step 2: reverse the second half
		ListNode cur = second;
		ListNode pre = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		second = pre;
		
		// step 3: interleave
		ListNode first = head;
		while (second != null) {
			ListNode nextFirst = first.next;
			ListNode nextSecond = second.next;
			
			first.next = second;
			second.next = nextFirst;
			
			first = nextFirst;
			second = nextSecond;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.createLinkedList(3);
		ReorderList r = new ReorderList();
		r.reorderList(head);
	}
}

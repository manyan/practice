package google;

import datastructure.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		int L = 0;
		while (fast != null) {
			fast = fast.next;
			L++;
		}
		
		k %= L;
		if (k == 0) {
			return head;
		}
		fast = head;
		slow = head;
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		
		return head;
	}
	
	public ListNode rotateRightSlow(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		while (k >= 0) {
			if (fast == null) {
				fast = head; // mod
			}
			fast = fast.next;
			k--;
		}
		
		if (fast == null) {
			return head;
		}
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		fast.next = head;
		head = slow.next;
		slow.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		RotateList r = new RotateList();
		r.rotateRight(head, 1);
	}
}

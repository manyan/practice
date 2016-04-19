package google;

import datastructure.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode smaller = new ListNode(0);
		ListNode sh = smaller;
		ListNode larger = new ListNode(0);
		ListNode lh = larger;
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			if (node.val < x) {
				smaller.next = node;
				smaller = smaller.next;
				smaller.next = null;
			} else {
				larger.next = node;
				larger = larger.next;
				larger.next = null;
			}
			node = next;
		}

		smaller.next = lh.next;
		return sh.next;
	}

	public static void main(String[] args) {

	}
}

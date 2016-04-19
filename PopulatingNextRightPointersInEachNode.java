package google;

import datastructure.TreeLinkNode;


public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		// find the next node for root's children
		TreeLinkNode next = root.next;
		while (next != null) {
			if (next.left != null) {
				next = next.left;
				break;
			}
			if (next.right != null) {
				next = next.right;
				break;
			}
			
			next = next.next;
		}
		
		// connect root's children
		if (root.right != null) {
			root.right.next = next;
		}
		if (root.left != null) {
			root.left.next = root.right == null ? next : root.right;
		}
		
		// connect right part first!
		connect(root.right);
		connect(root.left);
	}
}

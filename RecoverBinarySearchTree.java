package google;

import the.art.of.programming.tree.TreeNode;

public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		TreeNode node = root;
		TreeNode node1 = null;
		TreeNode node2 = null;
		TreeNode pre = null;
		
		while (node != null) {
			if (node.left == null) {
				// visit
				if (pre != null && pre.val > node.val) {
					if (node1 == null) {
						node1 = pre;
					} 
					node2 = node;
				}
				
				// then go to right child
				pre = node;
				node = node.right;
			} else {
				TreeNode tmp = node.left;
				while (tmp.right != null && tmp.right != node) {
					tmp = tmp.right;
				}
				if (tmp.right == null) {
					// connect 
					tmp.right = node;
					node = node.left;
				} else {
					// visit
					if (pre != null && pre.val > node.val) {
						if (node1 == null) {
							node1 = pre;
						} 
						node2 = node;
					}
					
					// break
					tmp.right = null;
					// move to right child
					pre = node;
					node = node.right;
				}
			}
		}
		
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}
}

package google;

import the.art.of.programming.tree.TreeNode;

public class BSTIterator {
	TreeNode node;

	public BSTIterator(TreeNode root) {
		node = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return node != null;
	}

	/** @return the next smallest number */
	public int next() {
		int val = Integer.MIN_VALUE;
		while (node != null) {
			if (node.left == null) {
				val = node.val;
				node = node.right;
				break;
			} else {
				TreeNode tmp = node.left;
				while (tmp.right != null && tmp.right != node) {
					tmp = tmp.right;
				}
				if (tmp.right == null) {
					tmp.right = node;
					node = node.left;
				} else {
					val = node.val;
					tmp.right = null;
					node = node.right;
					break;
				}
			}
		}
		
		return val;
	}
}

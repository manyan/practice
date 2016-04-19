package google;

import the.art.of.programming.tree.TreeNode;

public class CheckIsBST {
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if (min < root.val && root.val < max) {
			return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
		}
		
		return false;
	}
}

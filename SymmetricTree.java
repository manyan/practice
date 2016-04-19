package google;

import the.art.of.programming.tree.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	public boolean isSymmetric(TreeNode leftChild, TreeNode rightChild) {
		if (leftChild == null && rightChild == null) {
			return true;
		}
		if (leftChild == null || rightChild == null || leftChild.val != rightChild.val) {
			return false;
		}
		
		return isSymmetric(leftChild.right, rightChild.left) && isSymmetric(leftChild.left, rightChild.right);
	}
}

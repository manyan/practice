package google;

import the.art.of.programming.tree.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return check(root).isBalanced;
	}
	
	public Result check(TreeNode node) {
		Result result = new Result();
		if (node == null) {
			result.depth = 0;
			result.isBalanced = true;
			return result;
		}
		
		Result leftResult = check(node.left);
		if (leftResult.isBalanced == false) {
			return leftResult;
		}
		
		Result rightResult = check(node.right);
		if (rightResult.isBalanced == false) {
			return rightResult;
		}
		
		result.isBalanced = Math.abs(rightResult.depth - leftResult.depth) <= 1;
		result.depth = Math.max(leftResult.depth, rightResult.depth) + 1;
		return result;
	}
	
	public class Result {
		int depth;
		boolean isBalanced;
	}
}

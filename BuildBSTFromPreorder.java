package google;

import java.util.Stack;

import the.art.of.programming.tree.TreeNode;

public class BuildBSTFromPreorder {
	public TreeNode build(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		
		TreeNode root = new TreeNode(A[0]);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		for (int i = 1; i < A.length; i++) {
			TreeNode node = new TreeNode(A[i]);
			TreeNode tmp = null;
			while (!stack.isEmpty() && stack.peek().val < A[i]) {
				tmp = stack.pop();
			}
			
			if (tmp == null) {
				stack.peek().left = node;
			} else {
				tmp.right = node;
			}
			
			stack.push(node);
		}
		
		return root;
	}
	
	
	public TreeNode buildRecursively(int[] A) {
		index = 0; // reset
		return buildRecursively(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	// same logic of check binary tree
	private int index = 0;
	private TreeNode buildRecursively(int[] A, int min, int max) {
		if (index >= A.length || A[index] < min || A[index] > max) {
			return null; // invalid, return null
		}
		
		// reach here means min < A[index] < max
		TreeNode node = new TreeNode(A[index++]);
		node.left = buildRecursively(A, min, node.val);
		node.right = buildRecursively(A, node.val, max);
		
		return node;
	}
}

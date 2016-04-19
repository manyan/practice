package google;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import the.art.of.programming.tree.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(0, node.val);
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
		}
		
		return result;
	}
}

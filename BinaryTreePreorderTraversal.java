package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import the.art.of.programming.tree.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		TreeNode node = root;
		while (node != null) {
			if (node.left == null) {
				// visit
				result.add(node.val);
				node = node.right;
			} else {
				TreeNode tmp = node.left;
				while (tmp.right != null && tmp.right != node) {
					tmp = tmp.right;
				}
				
				if (tmp.right == null) {
					// connect and visit
					tmp.right = node;
					result.add(node.val);
					// move to its left as preorder
					node = node.left;
				} else {
					// break
					tmp.right = null;
					node = node.right;
				}
			}
		}
		
		return result;
	}
	
	public List<Integer> preorderTraversalBasedOnStack(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		
		return result;
	}
}

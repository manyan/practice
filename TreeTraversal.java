package google;

import java.util.Stack;

import the.art.of.programming.tree.TreeNode;

public class TreeTraversal {
	/*
	 * key of the morris traversal (both inorder and preorder) is to find the each node's inorder precendent
	 * then link them 
	 * */
	public void morrisInorder(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.val + " ");
				node = node.right;
			} else {
				TreeNode tmp = node.left;
				// find the rightmost node of current node's left
				while (tmp.right != null && tmp.right != node) {
					tmp = tmp.right;
				}
				
				if (tmp.right == null) {
					// link it
					tmp.right = node;
					node = node.left;
				} else {
					System.out.print(node.val + " ");
					tmp.right = null; // 
					node = node.right;
				}
			}
		}
	}
	
	// every similar to morris inorder
	public void morrisPreorder(TreeNode root) {
		TreeNode node = root;
		while (node != null) {
			if (node.left == null) {
				System.out.print(node.val + " ");
				node = node.right;
			} else {
				TreeNode tmp = node.left;
				while (tmp.right != null && tmp.right != node) {
					tmp = tmp.right;
				}
				
				if (tmp.right == null) {
					// first time encounter the current node, so print it
					System.out.print(node.val + " ");
					// connect it
					tmp.right = node;
					node = node.left;
				} else {
					// break it
					tmp.right = null;
					node = node.right;
				}
			}
		}
	}
	
	// using stack
	public void preorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			// because the nature of stack, we push right child before left child
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
	
	// by 2 stacks
	// if we observe carefully, the reverse order of post order is every similar to preorder, except we deal with push left then right
	public void postorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> result = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.push(node);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		while (!result.isEmpty()) {
			System.out.print(result.pop().val + " ");
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBST(10);
		TreeTraversal t = new TreeTraversal();
		t.morrisInorder(root);
		System.out.println();
		TreeNode.printLevelByLevel(root);
		System.out.println();
		t.morrisPreorder(root);
	}
}

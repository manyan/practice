package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import the.art.of.programming.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		
		TreeNode lastest = root;
		TreeNode rightmost = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		ArrayList<Integer> sol = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			sol.add(node.val);
			if (node.left != null) {
				queue.add(node.left);
				lastest = node.left;
			}
			if (node.right != null) {
				queue.add(node.right);
				lastest = node.right;
			}
			
			// check whether the current node is the rightmost node of the current level
			if (node == rightmost) {
				rightmost = lastest;
				result.add((ArrayList<Integer>)sol.clone());
				sol.clear();
			}
		}
		
		return result;
	}
}

package google;

import the.art.of.programming.tree.TreeNode;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}
	
	public int sumNumbers(TreeNode root, int cur) {
		if (root == null) {
			return cur;
		}
		
		cur = cur * 10 + root.val;
		if (root.left == null && root.right == null) {
			return cur;
		}
		int total = 0;
		if (root.left != null) {
			total += sumNumbers(root.left, cur);
		}
		if (root.right != null) {
			total += sumNumbers(root.right, cur);
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		System.out.println(s.sumNumbers(root));
	}
}

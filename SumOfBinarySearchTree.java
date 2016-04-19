package google;

import the.art.of.programming.tree.TreeNode;


/*
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-253-for-sde1i/
 * In a BST, replace value of each node with the sum of itself and everything greater than itself.
 * */
public class SumOfBinarySearchTree {
	public void sum(TreeNode root) {
		sumUp(root, 0);
	}
	
	public int sumUp(TreeNode root, int sum) {
		if (root == null) {
			return sum;
		}
		
		sum = sumUp(root.right, sum);
		root.val += sum;
		return sumUp(root.left, root.val);
	}
	
	public static void main(String[] args) {
		SumOfBinarySearchTree s = new SumOfBinarySearchTree();
		
		TreeNode root = TreeNode.createBST(5);
		s.sum(root);
		TreeNode.printLevelByLevel(root);
	}
}

package google;

import the.art.of.programming.tree.TreeNode;

/*
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * */
public class SumTree {
	public void convert(TreeNode root) {
		doConvert(root);
	}
	
	public int doConvert(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int sum = doConvert(node.left);
		sum += doConvert(node.right);
		sum += node.val;
		node.val = sum - node.val;
		
		return sum;
	}
	
	public static void main(String[] args) {
		SumTree s = new SumTree();
		
		TreeNode root = TreeNode.createBST(7);
		s.convert(root);
		TreeNode.printLevelByLevel(root);
	}
}

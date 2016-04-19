package google;

import java.util.LinkedList;
import java.util.List;

import the.art.of.programming.tree.TreeNode;

/*
 * http://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 * */
public class DiagonalSumOfBinaryTree {
	/*
	 * Based on observation: right child belows to the sam diagonal sum, left
	 * tree belongs to the next diagonal sum so lets do a pre order travesal
	 */
	public List<Integer> diagonalSum(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		diagonalSum(root, result, 0);
		return result;
	}

	public void diagonalSum(TreeNode node, List<Integer> result, int i) {
		if (node == null) {
			return;
		}

		// add the current val to the ith sum
		if (i < result.size() - 1) {
			result.set(i, result.get(i) + node.val);
		} else {
			result.add(node.val);
		}

		diagonalSum(node.left, result, i + 1);
		diagonalSum(node.right, result, i);
	}

	public static void main(String[] args) {
		DiagonalSumOfBinaryTree d = new DiagonalSumOfBinaryTree();
		TreeNode root = TreeNode.createBST(7);
		List<Integer> result = d.diagonalSum(root);
		for (int i : result) {
			System.out.println(i);
		}
	}
}

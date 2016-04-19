package google;

import the.art.of.programming.tree.TreeNode;

public class ConstructAncestorMatrix {
	public int[][] construct(TreeNode root, int n) {
		int[][] matrix = new int[n][n];
		int[] parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		construct(root, matrix, parent);
		return matrix;
	}
	
	private void construct(TreeNode node, int[][] matrix, int[] parent) {
		if (node == null) {
			return;
		}
		
		int row = node.val;
		if (node.left != null) {
			// make the current node as the parent of its child
			parent[node.left.val] = row;
			
			// propagate it all the way up
			int currentRow = row;
			while (parent[currentRow] != currentRow) {
				matrix[currentRow][node.left.val] = 1;
				currentRow = parent[currentRow];
			}
			matrix[currentRow][node.left.val] = 1;
			
			construct(node.left, matrix, parent);
		}
		if (node.right != null) {
			parent[node.right.val] = row;
			
			// propagate it all the way up
			int currentRow = row;
			while (parent[currentRow] != currentRow) {
				matrix[currentRow][node.right.val] = 1;
				currentRow = parent[currentRow];
			}
			matrix[currentRow][node.right.val] = 1;
			
			construct(node.right, matrix, parent);
		}
	}
}

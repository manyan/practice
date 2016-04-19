package google;

import the.art.of.programming.tree.TreeNode;

public class BinaryTreeMaximumPathSum {
	public class Result {
		int legSum; // max leg sum including the current node
		int pathSum; // max path sum that root at the current node
	}

	public int maxPathSum(TreeNode root) {
		return doMaxPathSum(root).pathSum;
	}
	
	public Result doMaxPathSum(TreeNode node) {
		// safe guard
		if (node == null) {
			return new Result();
		}
		
		Result result = new Result();
		if (node.left == null && node.right == null) {
			// leaf
			result.legSum = node.val;
			result.pathSum = node.val;
		} else if (node.left != null && node.right != null) {
			Result left = doMaxPathSum(node.left);
			Result right = doMaxPathSum(node.right);
			
			// legSum case 1: the max leg sum only contain the current node
			// legSum case 2: current node is just part of it
			result.legSum = Math.max(node.val, node.val + Math.max(left.legSum, right.legSum));
			
			// path sum cases
			// case 1: node itself
			int pathSum = node.val;
			// case 2: or its from its children
			pathSum = Math.max(pathSum, Math.max(left.pathSum, right.pathSum));
			// case 3: or it could be the leg sum
			pathSum = Math.max(pathSum, result.legSum);
			// case 4: or the current node could be the bridge connecting left and right legs
			pathSum = Math.max(pathSum, node.val + left.legSum + right.legSum);
			result.pathSum = pathSum;
		} else {
			TreeNode child = node.left == null ? node.right : node.left;
			Result tmp = doMaxPathSum(child);
			result.legSum = Math.max(node.val, node.val + tmp.legSum);
			result.pathSum = Math.max(result.legSum, tmp.pathSum);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createBST(3);
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		System.out.println(b.maxPathSum(root));
	}
}

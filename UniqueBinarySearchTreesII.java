package google;

import java.util.ArrayList;
import java.util.List;

import the.art.of.programming.tree.TreeNode;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(0, n);
	}
	
	public List<TreeNode> generateTrees(int from, int to) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (from > to) {
			result.add(null);
			return result;
		}
		if (from == to) {
			result.add(new TreeNode(from));
			return result;
		}
		
		for (int root = from; root <= to; root++) {
			List<TreeNode> leftTree = generateTrees(0, root-1);
			List<TreeNode> rightTree = generateTrees(root+1, to);
			for (TreeNode left : leftTree) {
				for (TreeNode right: rightTree) {
					TreeNode r = new TreeNode(root);
					r.left = left;
					r.right = right;
					result.add(r);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
		List<TreeNode> result = u.generateTrees(3);
	}
}

package google;

import java.util.ArrayList;
import java.util.List;

import the.art.of.programming.tree.TreeNode;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightSideView(root, result, 0, -1);
		return result;
	}
	
	// return view level
	public int rightSideView(TreeNode node, List<Integer> result, int curLevel, int viewLevel) {
		if (node == null) {
			return viewLevel;
		}
		
		if (curLevel > viewLevel) {
			viewLevel++;
			result.add(node.val);
		}
		
		viewLevel = rightSideView(node.right, result, curLevel+1, viewLevel);
		return rightSideView(node.left, result, curLevel+1, viewLevel);
	}
}

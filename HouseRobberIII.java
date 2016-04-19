package google;

import the.art.of.programming.tree.TreeNode;

/*
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * */
public class HouseRobberIII {
	public int rob(TreeNode root) {
        int[] result = doRob(root);
        return Math.max(result[0], result[1]);
    }
	
	// return int[2], {with root, without root}
	private int[] doRob(TreeNode root) {
		int[] result = new int[2];
		if (root == null) {
			return result;
		}
		
		int[] leftResult = doRob(root.left);
		int[] rightResult = doRob(root.right);
		
		int withRoot = root.val + leftResult[1] + rightResult[1];
		int withoutRoot = Math.max(leftResult[0], leftResult[1]) + Math.max(rightResult[0], rightResult[1]);
		
		result[0] = withRoot;
		result[1] = withoutRoot;
		
		return result;
	}
}

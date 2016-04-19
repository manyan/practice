package google.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * 
 * */
public class CountSmallerOrLargerElement {
	/*
	 * input: [5, 2, 6, 1] output: [1, 1, 0, 0] If there is not duplicate, we
	 * can just use the build-in SortedSet, but if there is duplicate, we need
	 * to use binary search tree
	 */
	public int[] countLargerElementFromItsRight(int[] nums) {
		return null;
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length == 0) {
			return result;
		} else {
			// Firstly, we make all the numbers in the array to be non-negative
			// by num[i] = num[i]-min
			int min = Integer.MAX_VALUE;
			for (int x : nums) {
				min = Math.min(x, min);
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				nums[i] -= min;
				max = Math.max(nums[i], max);
			}
			// Then build the array from 0 to max to realize the Binary Indexed
			// Tree
			// We traverse from the rightmost side towards leftmost side
			// When we reach a number num, array[num] update by 1
			int[] BIT = new int[max + 1];
			for (int i = nums.length - 1; i >= 0; i--) {
				result.add(getSum(BIT, nums[i] - 1));
				update(BIT, nums[i]);
			}
			// Then we need to reverse the result List cause it was built in
			// reversed order
			Collections.reverse(result);
			return result;
		}
	}

	private void update(int[] BIT, int val) {
		int fakeIndex = val + 1;
		while (fakeIndex <= BIT.length) {
			BIT[fakeIndex - 1] += 1;
			fakeIndex += fakeIndex & (-fakeIndex);
		}
	}

	private int getSum(int[] BIT, int val) {
		if (val < 0) {
			return 0;
		}
		int sum = 0;
		int fakeIndex = val + 1;
		while (fakeIndex > 0) {
			sum += BIT[fakeIndex - 1];
			fakeIndex -= fakeIndex & (-fakeIndex);
		}
		return sum;
	}
	
	

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int count; // as we might have dup
		int rightCount; // nodes on current nodes right part
		int leftCount; // nodes on current nodes left part

		public TreeNode(int val) {
			this.val = val;
			this.count = 1;
		}
	}

	public class Tree {
		TreeNode root;

		public void insert(int val) {
			if (root == null) {
				root = new TreeNode(val);
			}

			TreeNode node = root;
			while (true) {
				if (node.val == val) {
					node.count++;
					break;
				} else if (node.val > val) {
					node.leftCount++;
					if (node.left == null) {
						// insert
						node.left = new TreeNode(val);
						break;
					}
					node = node.left;
				} else {
					node.rightCount++;
					if (node.right == null) {
						// insert
						node.right = new TreeNode(val);
						break;
					}
					node = node.right;
				}
			}
		}

		// how many node with value < val in current tree
		public int smallerThan(int val) {
			if (root == null) {
				return 0;
			}

			TreeNode node = root;
			int c = 0;
			while (node != null) {
				if (node.val == val) {
					c += node.leftCount;
					break;
				} else if (node.val > val) {
					node = node.left;
				} else {
					c += node.count;
					c += node.leftCount;
					c += node.rightCount;
					break;
				}
			}

			return c;
		}
	}
}

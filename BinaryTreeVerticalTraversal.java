package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import the.art.of.programming.tree.TreeNode;

public class BinaryTreeVerticalTraversal {
	public List<Integer> printVertical(TreeNode root) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		SortedSet<Integer> set = new TreeSet<Integer>(); 
		printVertical(root, map, set, 0);
		List<Integer> result = new ArrayList<Integer>();
		for (int vertical : set) {
			List<Integer> col = map.get(vertical);
			System.out.print("Current vertical: " + vertical + ": ");
			for (int i : col) {
				result.add(i);
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		return result;
	}
	
	// return the leftmost vertical number
	public void printVertical(TreeNode node, Map<Integer, List<Integer>> map, SortedSet<Integer> set, int vertical) {
		if (node == null) {
			return;
		}
		
		// add the current node to the vertical
		if (!map.containsKey(vertical)) {
			map.put(vertical, new LinkedList<Integer>());
		}
		map.get(vertical).add(node.val);
		set.add(vertical);
		
		printVertical(node.left, map, set, vertical-1);
		printVertical(node.right, map, set, vertical+1);
	}
	
	public static void main(String[] args) {
		/*
		 * example: n = 7, ,1,2,3,4,5,6,7
		 *                     4
		 *                   /   \
		 *                  2      6
		 *                /  \     / \
		 *               1    3   5   7
		 * 
		 */
		BinaryTreeVerticalTraversal b = new BinaryTreeVerticalTraversal();
		List<Integer> result = b.printVertical(TreeNode.createBST(7));
	}
}

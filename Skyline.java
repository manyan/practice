package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * based on range tree
 * */
public class Skyline {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new LinkedList<int[]>();
		if (buildings == null || buildings.length == 0) {
			return result;
		}
		
		List<Building> bs = new ArrayList<Building>();
		for (int i = 0; i < buildings.length; i++) {
			bs.add(new Building(buildings[i][2], buildings[i][0], buildings[i][1]));
		}
		
		Collections.sort(bs);
		// as it could be a forest other than just a tree
		TreeNode root = new TreeNode(bs.get(0));
		for (int i = 1; i < bs.size(); i++) {
			insertToTree(root, bs.get(i));
		}
		
		traversal(root, result);
 		
		return result;
	}
	
	private boolean isOverlap(int l1, int r1, int l2, int r2) {
		int l = Math.max(l1, l2);
		int r = Math.min(r1, r2);
		return l <= r;
	}
	
	private void insertToTree(TreeNode root, Building building) {
		// safe guard, should not reach here
		if (root == null) {
			return;
		}
		
		if (root.L <= building.left && building.right <= root.R) {
			// fully covered, no need to insert, just return;
			return;
		}
		
		// special case, then their height is the same, and there is over lap, we need to extend the current node
		if (root.H == building.height && isOverlap(root.L, root.R, building.left, building.right)) {
			root.L = Math.min(root.L, building.left);
			root.R = Math.max(root.R, building.right);
			return;
		}
		
		Building leftBuilding = new Building(building.height, building.left, Math.min(root.L, building.right));
		if (leftBuilding.left < leftBuilding.right) {
			if (root.left == null) {
				root.left = new TreeNode(leftBuilding);
			} else {
				insertToTree(root.left, leftBuilding);
			}
		}
		
		Building rightBuilding = new Building(building.height, Math.max(building.left, root.R), building.right);
		if (rightBuilding.left < rightBuilding.right) {
			if (root.right == null) {
				root.right = new TreeNode(rightBuilding);
			} else {
				insertToTree(root.right, rightBuilding);
			}
		}
 	}
	
	// in order, based on morris travesal and keep the previous node
	private void traversal(TreeNode root, List<int[]> result) {
		TreeNode node = root;
		TreeNode pre = null;
		while (node != null) {
			if (node.left == null) {
				// visit
				if (pre != null && pre.R != node.L) {
					result.add(new int[] {pre.R, 0});
				}
 				result.add(new int[] {node.L, node.H});
				pre = node;
				node = node.right;
			} else {
				TreeNode tmp = node.left;
				while (tmp.right != null && tmp.right != node) {
					tmp = tmp.right;
				}
				
				if (tmp.right == null) {
					// connect
					tmp.right = node;
					node = node.left;
				} else {
					// visit
					if (pre != null && pre.R != node.L) {
						result.add(new int[] {pre.R, 0});
					}
					result.add(new int[] {node.L, node.H});
					pre = node;
					tmp.right = null; // break and recover
					node = node.right;
				}
			}
		}
		
		result.add(new int[] {pre.R, 0});
	}
	
	public static class TreeNode {
		int H;
		int L;
		int R;
		
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int H, int L, int R) {
			this.H = H;
			this.L = L;
			this.R = R;
		}
		
		public TreeNode(Building building) {
			this.H = building.height;
			this.L = building.left;
			this.R = building.right;
		}
	}
	
	public static class Building implements Comparable<Building>{
		int height;
		int left;
		int right;
		
		public Building(int height, int left, int right) {
			this.height = height;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int compareTo(Building other) {
			if (this.height == other.height) {
				// if height is the same, compare left
				if (this.left == other.left) {
					// if left is also the same, we the one with large width will be the first one
					return other.right - this.right;
				} else {
					return this.left - other.left;
				}
			}
			
			// the higher the fronter
			return other.height - this.height;
		}
		
		@Override
		public String toString() {
			return "[" + this.left + ", " + this.right + ", " + this.height + "]";
		}
	}
	
	public static void main(String[] args) {
		int[][] buildings = { {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8} };
		//int[][] buildings = { {2,9,10}, {3,7,15}, {5,12,12}};
		Skyline s = new Skyline();
		List<int[]> result = s.getSkyline(buildings);
		for (int[] element : result) {
			System.out.print("[" + element[0] + ", " + element[1] + "] ");
		}
	}
}

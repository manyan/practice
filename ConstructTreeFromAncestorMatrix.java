package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import the.art.of.programming.tree.TreeNode;

/*
 * http://www.geeksforgeeks.org/construct-tree-from-ancestor-matrix/
 * matrix[i][j] == 1 means i is j's ancestor
 * */
public class ConstructTreeFromAncestorMatrix {
	public class Node implements Comparable<Node>{
		int val;
		List<Integer> descendants;
		
		public Node(int val, List<Integer> ancestor) {
			this.val = val;
			this.descendants = ancestor;
		}
		
		public int compareTo(Node other) {
			return this.descendants.size() - other.descendants.size();
		}
	}
	
	public TreeNode construct(int[][] matrix) {
		Node[] nodes = new Node[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			List<Integer> descendants = new ArrayList<Integer>();
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 1) {
					descendants.add(j);
				}
			}
			
			nodes[i] = new Node(i, descendants);
		}
		
		Arrays.sort(nodes);
		int[] parent = new int[matrix.length];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		TreeNode[] treeNodes = new TreeNode[matrix.length];
		
		for (int i = 0; i < nodes.length; i++) {
			Node cur = nodes[i];
			TreeNode node = new TreeNode(cur.val);
			treeNodes[i] = node;
			if (cur.descendants.size() == 0) {
				// leaf node, continue
				continue; 
			}
			
			for (int des : cur.descendants) {
				if (parent[des] == des) {
					// des does not have a parent yet
					if (node.left == null) {
						node.left = treeNodes[des];
					} else {
						node.right = treeNodes[des];
					}
					
					parent[des] = i;
				}
			}
		}
		
		return treeNodes[nodes[nodes.length-1].val];
	}
}

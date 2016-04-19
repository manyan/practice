package google;

import java.util.LinkedList;
import java.util.Queue;

import the.art.of.programming.tree.TreeNode;

/*
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 * */
public class ConnectNodesAtSameLevel {
	public void connect(TreeNode root) {
		if (root == null) {
			return;
		}
		
		TreeNode next = root.next;
		while (next != null) {
			if (next.left != null) {
				next = next.left;
				break;
			}
			if (next.right != null) {
				next = next.right;
				break;
			}
			
			next = next.next;
		}
		
		if (root.right != null) {
			root.right.next = next;
		}
		if (root.left != null) {
			root.left.next = root.right != null ? root.right : next; 
		}
		
		connect(root.right);
		connect(root.left);
	}
	
	public void connectWithQueue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			// size of the current level
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				// if its not the last node
				if (i < size-1) {
					node.next = queue.peek();
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
	}
}

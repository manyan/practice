package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BKTree {
	public static class Node {
		String val;
		int weight;
		Map<Integer, Node> next;
		
		public Node(String val) {
			this.val = val;
			weight = 1;
			next = new HashMap<Integer, Node>();
		}
	}
	
	Node root;
	
	public BKTree() {
		
	}
	
	public BKTree(String[] candidates) {
		for (String c : candidates) {
			this.insert(c);
		}
	}
	
	public void insert(String val) {
		if (root == null) {
			root = new Node(val);
			return;
		}
		
		Node node = root;
		while(node != null) {
			int cost = editDistance(val, node.val);
			if (cost == 0) {
				node.weight++;
				break;
			}
			
			if (!node.next.containsKey(cost)) {
				node.next.put(cost, new Node(val));
				break;
			} 
			
			node = node.next.get(cost);
		}
	}
	
	// return the candidates that within the cost of overall targets
	public List<String> query(String val, int cost, int maxSize) {
		List<String> result = new LinkedList<String>();
		query(root, val, cost, maxSize, result);
		return result;
	}
	
	private void query(Node node, String val, int cost, int maxSize, List<String> result) {
		// threshold
		if (node == null || result.size() == maxSize) {
			return;
		}
		
		int dis = editDistance(node.val, val);
		if (dis <= cost) {
			result.add(node.val);
			if (dis == 0) {
				result.add(0, node.val);
				return;
			}
		}
		
		if (node.next.isEmpty()) {
			return;
		}
		
		for (int i = dis-cost; i <= dis+cost; i++) {
			if (node.next.containsKey(i)) {
				query(node.next.get(i), val, cost, maxSize, result);
			}
		}
	}
	
	private int editDistance(String s1, String s2) {
		int L1 = s1.length()+1;
		int L2 = s2.length()+1;
		int[][] dis = new int[L1][L2];
		for (int i = 1; i < L1; i++) {
			dis[i][0] = i;
		}
		
		for (int i = 1; i < L2; i++) {
			dis[0][i] = i;
		}
		
		for (int i = 1; i < L1; i++) {
			for (int j = 1; j < L2; j++) {
				int cost = s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1;
				dis[i][j] = Math.min(Math.min(dis[i-1][j], dis[i][j-1]) + 1, dis[i-1][j-1] + cost);
			}
		}
		
		return dis[L1-1][L2-1];
	}
	
	public static void main(String[] args) {
		String[] candidates = {"book", "books", "cake", "boo", "cape", "cart", "boon", "cook"};
		BKTree tree = new BKTree(candidates);
		
		List<String> result = tree.query("cups", 2, 10);
		for (String s : result) {
			System.out.println(s);
		}
	}
}

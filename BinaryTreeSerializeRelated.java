package google;

import java.util.StringTokenizer;

import the.art.of.programming.tree.TreeNode;

/*
 * we are going to answer 3 questions here
 * 1) serialize
 * 2) deserialize
 * 3) valid a giving serialize 
 * 
 * 
 * */
public class BinaryTreeSerializeRelated {
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.substring(0, sb.length()-1);
	}
	
	public void serialize(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("#,");
			return;
		}
		
		sb.append(node.val + ",");
		serialize(node.left, sb);
		serialize(node.right, sb);
	}
	
	public TreeNode deserialize(String val) {
		StringTokenizer tokenizer = new StringTokenizer(val, ",");
		return deserialize(tokenizer);
	}
	
	public TreeNode deserialize(StringTokenizer tokenizer) {
		if (!tokenizer.hasMoreElements()) {
			return null;
		}
		
		String val = tokenizer.nextToken();
		if (val.equals("#")) {
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = deserialize(tokenizer);
		node.right = deserialize(tokenizer);
		
		return node;
	}
	
	public boolean valid(String val) {
		StringTokenizer tokenizer = new StringTokenizer(val, ",");
		// diff means outbound edges - inbound edges, as the current serialize will give a full binary tree, so at the end diff == 0
		// init diff to 1 it because the first element will be the root
		int diff = 1;
		while (tokenizer.hasMoreElements()) {
			// the current node brings in one inbound edge
			diff--;
			if (diff < 0) {
				return false;
			}
			if (!tokenizer.nextToken().equals("#")) {
				// current node is not null, and it brings in 2 outbound edges
				diff +=2;
			}
		}
		
		return diff == 0;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.createANONBFS(false);
		TreeNode.printLevelByLevel(root);
		BinaryTreeSerializeRelated b = new BinaryTreeSerializeRelated();
		String val = b.serialize(root);
		System.out.println(val);
		System.out.println(b.valid(val));
		root = b.deserialize(val);
		TreeNode.printLevelByLevel(root);
	}
}

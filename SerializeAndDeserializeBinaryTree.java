package google;

import java.util.StringTokenizer;

import the.art.of.programming.tree.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString().substring(0, sb.length()-1);
	}
	
	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("# ");
			return;
		}
		
		sb.append(root.val + " ");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	
	public TreeNode deserialize(String data) {
		// default delimiter is " "
		StringTokenizer st = new StringTokenizer(data);
		return deserialize(st);
    }
	
	public TreeNode deserialize(StringTokenizer st) {
		if (!st.hasMoreTokens()) {
			return null;
		}
		
		String token = st.nextToken();
		if (token.equals("#")) {
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.parseInt(token));
		node.left = deserialize(st);
		node.right = deserialize(st);
		
		return node;
	}
	
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
		String data = s.serialize(null);
		System.out.println(data);
	}
}

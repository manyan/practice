package google;

import java.util.Stack;

public class VerifyPreorderSerializationOfBinaryTree {
	// based on in and out degree
	// as we use # to represent a leave node, so all the non-leave node will provide 2 out degree (to children) and 1 in degree(to parent)
	// except for the root node which only provide 2 out degree, and leave node will only provide 1 in degree
	// diff = out - in. if its valid, diff will never become negative, and it will become 0 after the process
	public boolean isValidSerialization(String preorder) {
		int diff = 1;
		String[] arr = preorder.split(",");
		for (int i = 0; i < arr.length; i++) {
			if (--diff < 0) {
				return false;
			}
			if (!arr[i].equals("#")) {
				diff += 2;
			}
		}
		
		return diff == 0;
	}
	
	// we chop the binary tree whenever we find a leave node, and continue doing that if after chopping its children, the current node becomes a leave as well
	// so and the every finally, the stack will only contain #
	public boolean isValidSerializationBasedOnStack(String preorder) {
		String[] arr = preorder.split(",");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
			// try to chop
			while (stack.size() >= 3 && stack.peek().equals("#")) {
				stack.pop();
				if (stack.peek().equals("#")) {
					// pop the second out
					stack.pop();
					// pop the third out, as we need to chop it
					String third = stack.pop();
					if (third.equals("#")) {
						return false; 
					}
					stack.push("#");
				} else {
					stack.push("#");
					break;
				}
			}
		}
		
		return stack.size() == 1 && stack.pop().equals("#");
	}
	
	public static void main(String[] args) {
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		VerifyPreorderSerializationOfBinaryTree v = new VerifyPreorderSerializationOfBinaryTree();
		System.out.println(v.isValidSerializationBasedOnStack(preorder));
	}
}

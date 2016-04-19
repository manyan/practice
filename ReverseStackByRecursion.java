package google;

import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * */
public class ReverseStackByRecursion {
	public void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		
		int tmp = stack.pop();
		reverse(stack);
		pushToBottom(stack, tmp);
	}
	
	public void pushToBottom(Stack<Integer> stack, int val) {
		if (stack.isEmpty()) {
			stack.push(val);
			return;
		}
		
		int tmp = stack.pop();
		pushToBottom(stack, val);
		stack.push(tmp);
	}
}

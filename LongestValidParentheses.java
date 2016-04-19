package google;

import java.util.Stack;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


 * */
public class LongestValidParentheses {
	// simplest version, only contains ()
	public int longestValidParentheses(String S) {
		if (S == null || S.isEmpty()) {
			return 0;
		}
		int max = 0;
		int leftMostValid = 0;
		char[] chars = S.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				stack.push(i);
			} else {
				// ()())
				if (stack.isEmpty()) {
					leftMostValid = i+1;
				} else {
					stack.pop();
					// ((((()()()()
					int tmp = stack.isEmpty() ? i - leftMostValid + 1 : i - stack.peek();
					max = Math.max(max, tmp);
				}
			}
		}
		
		return max;
	}
	
	// contains (), [] and {}
	public int longestValidParenthesesWithAll(String S) {
		if (S == null || S.isEmpty()) {
			return 0;
		}
		int max = 0;
		int leftMostValid = 0;
		char[] chars = S.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
				stack.push(i);
			} else {
				// when stack is empty, not does not match
				if (stack.isEmpty() || chars[i] == ')' && chars[stack.peek()] != '(' || chars[i] == ']' && chars[stack.peek()] != '[' || chars[i] == '}' && chars[stack.peek()] != '{') {
					stack.clear(); // if it does not match, not of the stack can match any more, so clear the whole stack, eg: ([}
					leftMostValid = i+1;
				} else {
					stack.pop();
					// ((((()()()()
					int tmp = stack.isEmpty() ? i - leftMostValid + 1 : i - stack.peek();
					max = Math.max(max, tmp);
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
	}
}

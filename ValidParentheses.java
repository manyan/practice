package google;

import java.util.Stack;

public class ValidParentheses {
	// only contain single kind of parentheses ()
	public boolean isValidSimplestVersion(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		if (s.length() % 2 == 1) {
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}

	/*
	 * now lets work on the real deal: 
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 * */
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		if (s.length() % 2 == 1) {
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					int index = stack.pop();
					if (chars[i] == ')' && chars[index] == '(' || chars[i] == ']' && chars[index] == '[' || chars[i] == '}' && chars[index] == '{') {
						// valid
					} else {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		ValidParentheses v = new ValidParentheses();
		System.out.println(v.isValid("()"));
	}
}

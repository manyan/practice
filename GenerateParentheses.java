package google;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		return generateParenthesis(n, 0, 0);
	}

	// n1 == (), n2 == [], n3 == {}
	public List<String> generateParenthesis(int n1, int n2, int n3) {
		List<String> result = new LinkedList<String>();
		generateParenthesis(n1,n2,n3, new Stack<Character>(), "", result);
		return result;
	}
	
	private void generateParenthesis(int n1, int n2, int n3, Stack<Character> stack, String str, List<String> result) {
		if (n1 == 0 && n2 == 0 && n3 == 0 && stack.isEmpty()) {
			result.add(str);
			return;
		}
		
		// add a right parenthesis
		if (!stack.isEmpty()) {
			char c = stack.pop();
			generateParenthesis(n1, n2, n3, stack, str+getRight(c), result);
			// recover
			stack.add(c);
		}
		
		// or add a (
		if (n1 > 0) {
			stack.add('(');
			generateParenthesis(n1-1, n2, n3, stack, str + "(", result);
			stack.pop();
		}
		
		if (n2 > 0) {
			stack.add('[');
			generateParenthesis(n1, n2-2, n3, stack, str + "[", result);
			stack.pop();
		}
		
		if (n3 > 0) {
			stack.add('{');
			generateParenthesis(n1, n2, n3-1, stack, str + "{", result);
			stack.pop();
		}
	}
	
	private char getRight(char c) {
		if (c == '(') {
			return ')';
		} else if (c == '[') {
			return ']';
		} else {
			return '}';
		}
	}
}

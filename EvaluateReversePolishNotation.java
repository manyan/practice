package google;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> numbers = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			String cur = tokens[i];
			if (isOperator(cur)) {
				int second = numbers.pop();
				int first = numbers.pop();
				numbers.push(operate(first, cur, second));
			} else {
				numbers.push(Integer.parseInt(cur));
			}
		}
		
		return numbers.pop();
	}
	
	public boolean isOperator(String s) {
		return s.matches("\\+|-|\\*|/");
	}
	
	public int operate(int first, String operator, int second) {
		switch (operator) {
		case "+":
			return first + second;
		case "-":
			return first - second;
		case "*":
			return first * second;
		default:
			return first / second;
		}
	}
	
	public static void main(String[] args) {
		String s = "*";
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		System.out.println(e.isOperator("d"));
	}
}

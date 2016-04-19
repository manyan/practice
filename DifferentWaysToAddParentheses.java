package google;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		if (isDigits(input)) {
			result.add(Integer.parseInt(input));
			return result;
		}

		// divide and conqur
		int L = input.length();
		for (int i = 0; i < L; i++) {
			char c = input.charAt(i);
			if (isOperator(c)) {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (Integer l : left) {
					for (Integer r : right) {
						result.add(eval(l, r, c));
					}
				}
			}
		}

		return result;
	}

	private int eval(int x, int y, char o) {
		if (o == '+') {
			return x + y;
		} else if (o == '-') {
			return x - y;
		} else {
			return x * y;
		}
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*';
	}

	private boolean isDigits(String input) {
		int L = input.length();
		for (int i = 0; i < L; i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				return false;
			}
		}

		return true;
	}
}

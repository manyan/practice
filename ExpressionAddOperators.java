package google;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		addOperators(num, target, 0, "", 0, 0, result);
		return result;
	}
	
	public void addOperators(String num, int target, int p, String cur, long calculated, long mul, List<String> result) {
		if (p == num.length()) {
			if (calculated == target) {
				result.add(cur);
			}
			return;
		}
		
		long n = 0;
		for (int i = p; i < num.length(); i++) {
			if(i != p && num.charAt(p) == '0') {
				break;
			}
			n = n * 10 + (num.charAt(i) - '0');
			
			if (p == 0) {
				addOperators(num, target, i+1, n+"", n, n, result);
			} else { 
				addOperators(num, target, i+1, cur + "+" + n, calculated+n, n, result);
				addOperators(num, target, i+1, cur + "-" + n, calculated-n, -n, result);
				addOperators(num, target, i+1, cur + "*" + n, calculated - mul + mul * n, mul*n, result);
			}
		}
	}
	
	public static void main(String[] args) {
		ExpressionAddOperators e = new ExpressionAddOperators();
		e.addOperators("105", 5);
	}
}

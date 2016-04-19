package google;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		return isAdditiveNumber(num, 0, new ArrayList<Long>());
	}
	
	public boolean isAdditiveNumber(String num, int p, List<Long> sol) {
		if (p == num.length()) {
			return sol.size() > 2;
		}
		
		if (sol.size() <= 1) {
			long cur = 0;
			for (int i = p; i < num.length(); i++) {
				cur = cur*10 + (num.charAt(i) - '0');
				sol.add(cur);
				if (isAdditiveNumber(num, i+1, sol)) {
					return true;
				}
				sol.remove(sol.size()-1);
				
				if (cur == 0) {
					break;
				}
			}
		} else {
			long sum = sol.get(sol.size()-1) + sol.get(sol.size()-2);
			long cur = 0;
			for (int i = p; i < num.length(); i++) {
				cur = cur*10 + (num.charAt(i) - '0');
				if (cur == sum) {
					sol.add(cur);
					if (isAdditiveNumber(num, i+1, sol)) {
						return true;
					}
					sol.remove(sol.size()-1);
					break;
				} else if (cur > sum) {
					break;
				}
				
				if (cur == 0) {
					break;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		AdditiveNumber a = new AdditiveNumber();
		System.out.println(a.isAdditiveNumber("199100199"));
		System.out.println(a.isAdditiveNumber("199100"));
	}
}

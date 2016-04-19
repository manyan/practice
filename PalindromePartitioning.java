package google;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		boolean[][] matrix = getPalindrome(s);
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		partition(s, 0, result, new ArrayList<String>(), matrix);
		return result;
	}
	
	public void partition(String s, int p, ArrayList<List<String>> result, ArrayList<String> sol, boolean[][] matrix) {
		if (p == s.length()) {
			result.add((ArrayList<String>)sol.clone());
			return;
		}
		
		for (int i = p; i < s.length(); i++) {
			if (matrix[p][i]) {
				sol.add(s.substring(p, i));
				partition(s, i+1, result, sol, matrix);
				sol.remove(sol.size()-1);
			}
		}
	}
		
	public boolean[][] getPalindrome(String s) {
		int L = s.length();
		boolean[][] matrix = new boolean[L][L];
		for (int i = 0; i < L; i++) {
			matrix[i][i] = true;
		}
		for (int len = 2; len <= L; len++) {
			for (int left = 0; len + left - 1 < L; left++) {
				int right = len + left - 1;
				if (s.charAt(left) == s.charAt(right) && (left+1 >= right-1 || matrix[left+1][right-1])) {
					matrix[left][right] = true;
				}
			}
		}
		
		return matrix;
	}
}

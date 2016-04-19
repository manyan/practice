package google;

public class ShortestPalindrome {
	/*
	 * based on the same idea of the original one, but using KMP
	 * */
	public String shortestPalindromeImproved(String s) {
		if (s == null || s.isEmpty() || s.length() <= 1) {
			return s;
		}
		
		String rev = reverse(s);
		String ss = s + "#" + rev;
		int[] next = KMPNext(ss);
		int len = next[ss.length()];
		return len == s.length() ? s : rev.substring(0, next[ss.length()]) + s;
	}
	
	public int[] KMPNext(String s) {
		int L = s.length();
		int[] next = new int[L+1];
		next[0] = -1;
		int j = -1;
		int i = 0;
		while (i < L) {
			if (j == -1 || s.charAt(i) == s.charAt(j)) {
				next[++i] = ++j;
			} else {
				j = next[j];
			}
		}
		
		return next;
	}
	
	
	public String shortestPalindrome(String s) {
		if (s == null || s.isEmpty() || s.length() <= 1) {
			return s;
		}
		
		// lets just add the whole string in front of it
		int len = s.length();
		s = reverse(s) + s;
		int rightmost = s.length()-1;
		boolean[][] result = getPalindrome(s);
		for (int i = s.length() - len; i >= 0; i--) {
			if (result[i][rightmost]) {
				return s.substring(i, rightmost+1);
			}
		}
		
		return s;
	}
	
	public void swap(char[] chars, int i, int j) {
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
	}
	
	public String reverse(String s) {
		char[] chars = s.toCharArray();
		int left = 0;
		int right = chars.length-1;
		while (left < right) {
			swap(chars, left, right);
			left++;
			right--;
		}
		return new String(chars);
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
	
	public static void main(String[] args) {
		ShortestPalindrome s = new ShortestPalindrome();
		System.out.println(s.shortestPalindromeImproved("abb"));
	}
}

package google;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String S) {
		int L = S.length();
		// palin[i][j] == true, means S[i...j] is palindrome
		boolean[][] palin = new boolean[L][L];
		for (int i = 0; i < L; i++) {
			palin[i][i] = true;
		}
		
		int max = 1;
		int s = 0;
		int e = 0;
		for (int len = 2; len <= L; len++) {
			for (int left = 0; len+left-1 < L; left++) {
				int right = len+left-1;
				if (S.charAt(left) == S.charAt(right) && (left+1 >= right-1 || palin[left+1][right-1])) {
					palin[left][right] = true;
					if (len > max) {
						max = len;
						s = left;
						e = right;
					}
				}
			}
		}
		
		return S.substring(s, e+1);
	}
	
	public static void main(String[] args) {
		
	}
}

package google;

public class PalindromePartitioningII {
	public int minCut(String s) {
		boolean[][] matrix = getPalindrome(s);
		int L = s.length();
		if (matrix[0][L-1]) {
			return 0;
		}
		
		// min[i], means the min cur from [0...i]
		int[] min = new int[L];
		for (int i = 0; i < L; i++) {
			if (matrix[0][i]) {
				continue;
			}
			int m = i;
			for (int j = 1; j <= i; j++) {
				if (matrix[j][i]) {
					m = Math.min(m, min[j-1] + 1);
				}
			}
			min[i] = m;
		}
		
		return min[L-1];
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
		PalindromePartitioningII p = new PalindromePartitioningII();
		System.out.println(p.minCut("coder"));
	}
}

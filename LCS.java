package google;

public class LCS {
	public int lcs(String s1, String s2) {
		int row = s1.length();
		int col = s2.length();
		int[][] matrix = new int[row+1][col+1];
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				matrix[i][j] = matrix[i-1][j-1] + (s1.charAt(i-1) == s2.charAt(j-1) ? 1 : 0);
				matrix[i][j] = Math.max(matrix[i][j], matrix[i-1][j]);
				matrix[i][j] = Math.max(matrix[i][j], matrix[i][j-1]);
			}
		}
		
		return matrix[row-1][col-1];
	}
}

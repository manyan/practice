package google;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
		
		boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];
		matrix[0][0] = true;
		for (int i = 1; i <= s2.length(); i++) {
			if (s2.charAt(i-1) == s3.charAt(i-1)) {
				matrix[0][i] = true;
			} else {
				break;
			}
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.charAt(i-1) == s3.charAt(i-1)) {
				matrix[i][0] = true;
			} else {
				break;
			}
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s3.charAt(i+j-1) == s1.charAt(i-1) && matrix[i-1][j] || s3.charAt(i+j-1) == s2.charAt(j-1) && matrix[i][j-1]) {
					matrix[i][j] = true;
				}
			}
		}
		
		return matrix[s1.length()][s2.length()];
	}
}

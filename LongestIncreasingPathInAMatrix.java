package google;

public class LongestIncreasingPathInAMatrix {
	// brute force will lead to time limit exceed
	public int longestIncreasingPathTLE(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int max = 1;
		int[][] result = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				max = Math.max(max, longestIncreasingPath(matrix, i, j, result));
			}
		}
		
		return max;
	}
	
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int max = 1;
		int[][] result = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, longestIncreasingPath(matrix, i, j, result));
			}
		}
		
		return max;
	}

	// longest path we can find start from [i, j]
	public int longestIncreasingPath(int[][] matrix, int i, int j, int[][] result) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return 0;
		}
		
		if (result[i][j] > 0) {
			return result[i][j];
		}

		int max = 0; // itself
		// upper
		if (i-1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
			max = Math.max(max, longestIncreasingPath(matrix, i - 1, j, result));
		}
		// down
		if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
			max = Math.max(max, longestIncreasingPath(matrix, i+1, j, result));
		}

		// left
		if (j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]) {
			max = Math.max(max, longestIncreasingPath(matrix, i, j-1, result));
		}
		// right
		if (j + 1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]) {
			max = Math.max(max, longestIncreasingPath(matrix, i, j+1, result));
		}

		max++;
		result[i][j] = max;
		return max;
	}
	
	public static void main(String[] args) {
		int[][] matrix ={{3,3,14,2,17,12,5}};
		LongestIncreasingPathInAMatrix l = new LongestIncreasingPathInAMatrix();
		System.out.println(l.longestIncreasingPath(matrix));
	}
}

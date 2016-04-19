package google;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n <= 0) {
			return new int[0][0];
		}
		
		int[][] result = new int[n][n];
		int top = 0;
		int bottom = n-1;
		int left = 0;
		int right = n-1;
		
		int c = 1;
		while (top <= bottom && left <= right) {
			// top
			int i = left;
			while (i <= right) {
				result[top][i++] = c++;
			}
			top++;
			if (top > bottom) {
				break;
			}
			
			// right
			i = top;
			while (i <= bottom) {
				result[i++][right] = c++;
			}
			right--;
			if (left > right) {
				break;
			}
			
			// bottom
			i = right;
			while (i >= left) {
				result[bottom][i--] = c++;
			}
			bottom--;
			
			// left
			i = bottom;
			while (i >= top) {
				result[i--][left] = c++;
			}
			left++;
		}
		
		return result;
	}
}

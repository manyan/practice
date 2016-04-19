package google;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length <= 1 || matrix[0].length <= 1) {
			return;
		}
		
		int top = 0;
		int down = matrix.length-1;
		int left = 0;
		int right = matrix[0].length-1;
		while (top < down) {
			for (int i = 0; i <= down - top; i++) {
				int tmp = matrix[top][left+i];
				matrix[top][left+i] = matrix[down-i][left];
				matrix[down-i][left] = matrix[down][right-i];
				matrix[down][right-i] = matrix[top+i][right];
				matrix[top+i][right] = tmp;
			}		
			
			top++;
			down--;
			left++;
			right--;
		}
	}
}

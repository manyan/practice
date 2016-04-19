package google;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}

		int top = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (top <= down && left <= right) {
			// top
			int i = left;
			while (i <= right) {
				result.add(matrix[top][i]);
				i++;
			}
			top++;
			if (top > down) {
				break;
			}

			// right
			i = top;
			while (i <= down) {
				result.add(matrix[i][right]);
				i++;
			}
			right--;
			if (left > right) {
				break;
			}

			// bottom
			i = right;
			while (i >= left) {
				result.add(matrix[down][i]);
				i--;
			}
			down--;

			// left
			i = down;
			while (i >= top) {
				result.add(matrix[i][left]);
				i--;
			}
			left++;
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2},{3,4}};
		SpiralMatrix s = new SpiralMatrix();
		s.spiralOrder(matrix);
	}
}

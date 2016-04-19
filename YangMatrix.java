package google;

/*
 * [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 * 
 * */
public class YangMatrix {
	// return the rank of val, regardless it exists or not
	public int getRank(int[][] matrix, int val) {
		int top = 0;
		int right = matrix[0].length-1;
		int rank = 0;
		while (top < matrix.length && right >= 0) {
			if (matrix[top][right] == val) {
				rank += right+1;
				break;
			} else if (matrix[top][right] < val) {
				rank += right+1;
				top++;
			} else {
				right--;
			}
		}

		return rank;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				  {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}
				};
		
		YangMatrix y = new YangMatrix();
		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " : " + y.getRank(matrix, i));
		}
	}
}

package google;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 * */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// from right top corner
		int right = matrix[0].length-1;
		int top = 0;
		while (right >= 0 && top < matrix.length) {
			if (matrix[top][right] == target) {
				return true;
			} else if (matrix[top][right] > target) {
				right--;
			} else {
				top++;
			}
		}
		
		return false;
	}
}

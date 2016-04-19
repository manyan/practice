package google;
/*
 * http://www.geeksforgeeks.org/maximum-product-subarray/
 * 
 * Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
Output:   80  // The subarray is {-2, -40}
 * */
public class MaxProductOfArray {
	public int maxProduct(int[] A) {
		int max = A[0];
		int min = A[0];
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			int tmp = max;
			max = Math.max(A[i], Math.max(max*A[i], min*A[i]));
			min = Math.min(A[i], Math.min(tmp*A[i], min*A[i]));
			result = Math.max(result, max);
		}
		return result;
	}
}

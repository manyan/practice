package google;

public class MaxProduct {
	public int max(int[] A) {
		int max = A[0];
		int min = A[0];
		int result = A[0];
		
		for (int i = 1; i < A.length; i++) {
			int tmp = max;
			max = Math.max(A[i], Math.max(A[i] * max, A[i] * min));
			min = Math.min(A[i], Math.min(A[i] * tmp, A[i] * min));
			result = Math.max(result, max);
		}
		return result;
	}
}

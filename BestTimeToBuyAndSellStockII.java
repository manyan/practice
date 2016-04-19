package google;

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		
		int min = A[0];
		int result = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > min) {
				result += A[i] - min;
			}
			min = A[i];
		}
		
		return result;
	}
}

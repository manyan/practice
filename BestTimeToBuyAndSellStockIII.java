package google;

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		
		// left[i] means the max profile we can get between[0...i], in one transaction 
		int[] left = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = prices[i] > min ? prices[i] - min : 0;
			min = Math.min(min, prices[i]);
		}
		
		int max = prices[prices.length-1];
		int result = 0;
		int maxProfitFromRight = 0;
		for (int i = prices.length-2; i >= 0; i--) {
			if (prices[i] < max) {
				maxProfitFromRight = Math.max(maxProfitFromRight, max - prices[i]);
			}
			max = Math.max(max, prices[i]);
			
			result = Math.max(result, maxProfitFromRight + left[i]);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {2,1,2,0,1};
		BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
		b.maxProfit(A);
	}
}

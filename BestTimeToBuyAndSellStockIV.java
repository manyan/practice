package google;

/*
 * based on: http://blog.csdn.net/linhuanmars/article/details/23236995
 * 
 * */
public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length <= 1 || k == 0) {
			return 0;
		}
		
		// local[i][j] means max profit we can get from day [0...i] with max j transactions, and at the ith day, we MUST sell the stock
		int[][] local = new int[prices.length][k+1];
		// global[i][j] means max profit we can get from day [0...j] with max j transactions.
		int[][] global = new int[prices.length][k+1];
		
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i-1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(global[i-1][j-1] + diff, local[i-1][j] + diff);
				global[i][j] = Math.max(local[i][j], global[i-1][j]);
			}
		}
		
		return global[prices.length-1][k];
	}
	
	public int maxProfitImproved(int k, int[] prices) {
		if (prices == null || prices.length <= 1 || k == 0) {
			return 0;
		}
		
		// this is just to handle special cases as the k could be damn big
		if (2*k >= prices.length ) {
			int sum = 0;
			for (int i = 1; i < prices.length; i++) {
				int diff = prices[i] - prices[i-1];
				sum += Math.max(diff, 0);
			}
			
			return sum;
		}
		
		int[] local = new int[k+1];
		int[] global = new int[k+1];
		
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i-1];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(global[j-1] + diff, local[j] + diff);
				global[j] = Math.max(local[j], global[j]);
			}
		}
		
		return global[k];
	}
	
	// from: http://www.jiuzhang.com/solutions/best-time-to-buy-and-sell-stock-iv/
	public int maxProfitAnother(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1 || k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int n = prices.length;
        int[][] mustsell = new int[n][k + 1];   // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n][k + 1];  // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
       
        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[(i - 1)][j - 1] + gainorlose,
                                            mustsell[(i - 1)][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[(i - 1)][j], mustsell[i ][j]);
            }
        }
        
        return globalbest[(n - 1)][k];
    }
	
	public static void main(String[] args) {
//		int[] prices = {3,2,6,5,0,3};
//		BestTimeToBuyAndSellStockIV b = new BestTimeToBuyAndSellStockIV();
//		System.out.println(b.maxProfit(2, prices));
//		System.out.println(b.maxProfitImproved(2, prices));
		
		System.out.println(Integer.highestOneBit(45));
	}
}

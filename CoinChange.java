package google;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] result = new int[amount+1];
		for (int i = 1; i <= amount; i++) {
			result[i] = -1;
		}
		for (int i = 1; i <= amount; i++) {
			for (int c : coins) {
				if (i >= c && result[i-c] != -1) {
					if (result[i] == -1) {
						result[i] = result[i-c] + 1;
					} else {
						result[i] = Math.min(result[i], result[i-c] + 1);
					}
				}
			}
		}
		
		return result[amount];
	}
}

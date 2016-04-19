package google;

public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] nonprimes = new boolean[n];
		nonprimes[0] = true;
		nonprimes[1] = true;
		for (int i = 2; i * i < n; i++) {
			for (int j = i+i; j < n; j+=i) {
				nonprimes[j]= true;
			}
		}
		int count = 0;
		for (int i = 0; i <= n; i++) {
			if (!nonprimes[i]) {
				count++;
			}
		}
		
		return count;
	}
}

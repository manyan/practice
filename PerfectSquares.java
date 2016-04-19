package google;

public class PerfectSquares {
	public int numSquares(int n) {
		int[] result = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int min = i; // worst case senarios: can only be the sum of #i 1
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, 1 + result[i-j*j]);
			}
			result[i] = min;
		}
		return result[n];
	}
	
	public static void main(String[] args) {
		PerfectSquares p = new PerfectSquares();
		System.out.println(p.numSquares(2));
	}
}

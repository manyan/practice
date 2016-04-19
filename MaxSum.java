package google;

public class MaxSum {
	public int max(int[] A) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i : A) {
			sum += i;
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		
		return max;
	}
}

package google;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		} if (n <= 2) {
			return n;
		}
		
		int first = 1;
		int second = 2;
		int i = 3;
		while (i <= n) {
			int tmp = first+second;
			first = second;
			second = tmp;
		}
		
		return second;
	}
}

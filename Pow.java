package google;

public class Pow {
	public double myPowRecur(double x, int n) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		
		boolean isNegative = n < 0 ? true : false;
		n = Math.abs(n);
		
		double result = doMyPow(x, n);
		return isNegative ? 1/result : result;
	}
	
	/*
	 * observation:
	 * whenever n becomes odd, it contribute one x, and it will contribute the multi of two halfs
	 * hence we can do it iteralatively
	 * */
	public double doMyPow(double x, int n) {
		if (n == 1) {
			return x;
		}
		
		int m = n/2;
		double half = doMyPow(x, m);
		return half * half * ((n&1) == 1 ? x : 1);
	}
	
	public double myPow(double x, int n) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		
		double result = 1;
		boolean isNegative = n < 0 ? true : false;
		
		n = Math.abs(n);
		while (n >= 1) {
			if ((n&1) == 1) {
				// odd length
				result *= x;
				if (n == 1) {
					break;
				}
			}
			
			x *= x;
			n /= 2;
		}
		
		return isNegative ? 1/result : result;
	}
	
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.myPow(2, 7));
		System.out.println(p.doMyPow(2, 7));
	} 
}

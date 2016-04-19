package google;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (divisor == 0) {
			return Integer.MIN_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		
		int sign = ((dividend ^ divisor) >> 31) == 0 ? 1 : -1; 
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		long result = 0;
		while (a >= b) {
			long c = b;
			//for (int i = 0; a >= c; i++, c<<i) {
			for (int i = 0; a >= c; i++, c <<= 1) {
				a -= c;
				result += 1 << i;
			}
		}
		
		return (int)(result * sign);
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-2147483648,-1));
	}
}

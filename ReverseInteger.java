package google;

/*
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 * */
public class ReverseInteger {
	public int reverse(int x) {
		int sign = x < 0 ? -1: 1;
		long y = Math.abs(x);
		long r = 0;
		while (y > 0) {
			r = r * 10 + (y%10);
			y /= 10;
		}
		
		r *= sign;
		if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) {
			return 0;
		}
		
		return (int)r;
	}
	
	public static void main(String[] arsg) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(-123));
		
		int x = 4123;
		while (x > 10) {
			x /= 10;
		}
		System.out.println(x);
	}
}

package google;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int sum = 0;
		int pow = 5;
		while (pow <= n) {
			sum += n/pow;
			pow *= 5;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		System.out.println(f.trailingZeroes(167));
	}
}

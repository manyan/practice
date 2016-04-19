package google;

public class BitwiseANDOfNumbersRange {
	/*
	 * basically, we need to find the largest prefix of all this numbers
	 * and we only check the smallest and the largest as they will cover all the cases
	 * */
	public int rangeBitwiseAnd(int m, int n) {
		int c = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			c++;
		}
		
		return n << c;
	}
}

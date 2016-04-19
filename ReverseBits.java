package google;

public class ReverseBits {
	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i <= 31; i++) {
			result <<= 1;
			result |= (n&1);
			n <<= 1;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		int i = -1;
		System.out.println((i >> 10));
		System.out.println((i >> 50));
	}
}

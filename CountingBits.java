package google;

public class CountingBits {
	public int[] countBits(int num) {
		int[] result = new int[num+1];
		for (int i = 0; i <= num; i++) {
			result[i] = doCountBits(i);
		}
		return result;
	}
	
	public int doCountBits(int number) {
		int bits = 0;
		while (number > 0) {
			number = number & (number-1);
			bits++;
		}
		
		return bits;
	}
	
	public int[] countBitsDP(int num) {
		int[] result = new int[num+1];
		if (num == 0) {
			return result;
		}
		
		result[1] = 1;
		for (int i = 2; i <= num; i++) {
			if ((i & (i-1)) == 0) {
				result[i] = 1;
			} else {
				int tmp = Integer.highestOneBit(i);
				result[i] = 1 + result[i-tmp];
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(awesomeMethodFromSourceCode(-1));
		System.out.println(1 << 31);
	}
	
	public static int awesomeMethodFromSourceCode(int i) {
		i |= i >> 1;
		i |= i >> 2;
		i |= i >> 4;
		i |= i >> 8;
		i |= i >> 16;
		return i - (i >>> 1);
	}
}

package google;

public class BitMagic {
	public int getHighestBit(int i) {
		i |= i >> 1;
		i |= i >> 2;
		i |= i >> 4;
		i |= i >> 8;
		i |= i >> 16;
		
		return i - (i >>> 1);
	}
	
	public int getLowestBit(int i) {
		return i & (-i);
	}
	
	public int numberOfSetBit(int i) {
		int count = 0;
		while (i != 0) {
			i &= i-1;
			count++;
		}
		return count;
	}
	
	
}

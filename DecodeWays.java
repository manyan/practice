package google;

public class DecodeWays {
	//dp
	public int numDecodings(String s) {
		if (s == null || s.isEmpty() || s.charAt(0) == '0') {
			return 0;
		}
		
		int[] ways = new int[s.length()];
		ways[0] = 1;
		for (int i = 1; i < ways.length; i++) {
			int pre = s.charAt(i-1) - '0';
			int cur = s.charAt(i) - '0';
			ways[i] = ways[i-1];
			if (cur == 0) {
				if (pre == 0 || pre > 2) {
					return 0; // invalid
				} else {
					ways[i] = i - 2 >= 0 ? ways[i-2] : 1;
				}
			} else {
				if (pre == 1 || pre == 2 && 1 <= cur && cur <= 6) {
					ways[i] += i - 2 >= 0 ? ways[i-2] : 1;
				}
			}
			
		}
		
		return ways[ways.length-1];
	}
	
	// recursive
	public int numDecodingsRecur(String s) {
		return numDecodingsRecur(s, 0);
	}
	
	public int numDecodingsRecur(String s, int p) {
		if (p == s.length()) {
			return 1;
		}
		
		int count = 0;
		int sum = 0;
		for (int i = p; i < s.length(); i++) {
			sum = sum * 10 + (s.charAt(i) - 0);
			if (0 < sum && sum <= 26) {
				count += numDecodingsRecur(s, i+1);
			} else {
				break;
			}
		}
		
		return count;
	}
}

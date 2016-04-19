package google;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int min = Integer.MAX_VALUE;
		int l = 0;
		int r = 0;
		
		int[] checks = new int[256];
		int count = 0;
		for (int i = 0; i < t.length(); i++) {
			int index = t.charAt(i);
			if (checks[index] == 0) {
				count++;
			}
			checks[index]--;
		}
		
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			checks[index]++;
			if (checks[index] == 0) {
				count--;
			}
			
			if (count == 0) {
				// lets shrink the windows from the left
				while (left < i) {
					if (checks[s.charAt(left)] <= 0) {
						break;
					}
					
					checks[s.charAt(left)]--;
					left++;
				}
				
				// check min
				if (i - left + 1 < min) {
					min = i - left + 1;
					l = left;
					r = i;
				}
			}
		}
		
		return min == Integer.MAX_VALUE ? "" : s.substring(l, r+1);
	}
}

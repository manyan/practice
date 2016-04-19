package google;

import java.util.Arrays;

public class HIndex {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			int c = citations[i];
			int n = i+1;
			if (n >= c) {
				return c;
			}
		}
		
		return 0;
	}
}

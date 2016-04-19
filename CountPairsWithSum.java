package google;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * */
public class CountPairsWithSum {
	public int count(int[] A, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			int remainder = sum - A[i];
			if (map.containsKey(remainder)) {
				count += map.get(remainder);
			}
			
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}
		
		return count;
	}
}

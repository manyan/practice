package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] A) {
		// [left, right] will be represented as range[left] = right, range[right] = left
		Map<Integer, Integer> range = new HashMap<Integer, Integer>();
		int max = 0;
		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (visited.contains(A[i])) {
				continue;
			}
			
			int val = A[i];
			visited.add(val);
			int left = val;
			int right = val;
			
			if (range.containsKey(val+1) && range.get(val+1) >= val+1) {
				// extend the right range
				right = range.get(val+1);
			}
			if (range.containsKey(val-1) && range.get(val-1) <= val-1) {
				// extend the left range
				left = range.get(val-1);
			}
			
			range.put(left, right);
			range.put(right, left);
			max = Math.max(max, right-left+1);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
		LongestConsecutiveSequence l = new LongestConsecutiveSequence();
		System.out.println(l.longestConsecutive(A));
	}
	
	public int improve(int[] A) {
		if (A == null || A.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for (int i : A) {
            set.add(i);
        }
        
        int max = 0;
        for (int i : A) {
            if (set.contains(i)) {
                set.remove(i);
                // use i as the pivot, try to stretch out to i's left and right
                int left = i-1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                
                int right = i+1;
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                }
                
                left++;
                right--;
                
                max = Math.max(max, right - left + 1);
            }
        }
        
        return max;
	}
}

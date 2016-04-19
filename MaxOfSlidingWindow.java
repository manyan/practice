package google;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return new int[0];
		}
		
		int[] result = new int[nums.length-k+1];
		Deque<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
				queue.removeLast();
			}
			
			queue.addLast(i);
		}
		
		for (int i = k; i < nums.length; i++) {
			result[i-k] = nums[queue.getFirst()];
			
			// remove if its outside of current window
			while (!queue.isEmpty() && queue.getFirst() <= i - k) {
				queue.removeFirst();
			}
			
			while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
				queue.removeLast();
			}
			
			queue.addLast(i); 
		}
		
		result[nums.length - k] = nums[queue.getFirst()];
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1};
		MaxOfSlidingWindow m = new MaxOfSlidingWindow();
		m.maxSlidingWindow(nums, 1);
	}
}

package google;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Subscribe to see which companies asked this question
 * */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closet = 0;
		int diff = Integer.MAX_VALUE;
		for (int first = 0; first < nums.length-2; first++) {
			int second = first+1;
			int third = nums.length-1;
			int remainder = target - nums[first];
			while (second < third) {
				int sum = nums[second] + nums[third];
				if (sum == remainder) {
					return target;
				} else {
					int tmp = Math.abs(remainder - sum);
					if (tmp < diff) {
						diff = tmp;
						closet = sum + nums[first];
					}
					
					if (sum > remainder) {
						third--;
					} else {
						second++;
					}
				}
			}
		}
		
		return closet;
	}
}

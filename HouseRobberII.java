package google;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		
		return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
	}
	
	public int rob(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		if (left > right) {
			return 0;
		}
		
		int[] max = new int[right - left + 1];
		max[0] = nums[left];
		max[1] = Math.max(nums[left+1], nums[left]);
		for (int i = 2; i < max.length; i++) {
			max[i] = Math.max(max[i-1], max[i-2] + nums[i+left]);
		}
		
		return max[max.length-1];
	}
}

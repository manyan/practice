package google;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int min = nums.length + 1;
		int left = 0;
		int i = 0;
		int sum = 0;
		while (i < nums.length) {
			if (nums[i] >= s) {
				return 1;
			}
			
			sum += nums[i];
			if (sum >= s) {
				while (sum - nums[left] >= s && left < i) {
					sum -= nums[left];
					left++;
				}
				min = Math.min(min, i - left + 1);
			}
			i++;
		}
		
		return min == nums.length+1 ? 0 : min;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
		System.out.println(m.minSubArrayLen(15, nums));
	}
}

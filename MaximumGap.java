package google;

public class MaximumGap {
	// https://leetcode.com/discuss/85134/short-straightforward-java-solution-radix-sort-manipulation
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		
		msdSort(nums, 0, nums.length-1, 1 << 30);
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i] - nums[i-1]);
		}
		
		return max;
	}
	
	public void msdSort(int[] nums, int left, int right, int pow) {
		if (left >= right || pow == 0) {
			return;
		}
		
		int rightMost = right;
		int i = left;
		while (i <= rightMost) {
			if ((pow & nums[i]) > 0) {
				int tmp = nums[rightMost];
				nums[rightMost] = nums[i];
				nums[i] = tmp;
				rightMost--;
			} else {
				i++;
			}
		}
		
		msdSort(nums, left, rightMost, pow >> 1);
		msdSort(nums, rightMost+1, right, pow >> 1);
	}
	
	public static void main(String[] args) {
		MaximumGap m = new MaximumGap();
		int[] nums = {2,7,6,4,1};
		m.msdSort(nums, 0, nums.length-1, 1<<2);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}

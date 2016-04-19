package google;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] lis = new int[nums.length];
		lis[0] = 1;
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
			
			max = Math.max(max, lis[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.print(l.lengthOfLIS(nums));
	}
}

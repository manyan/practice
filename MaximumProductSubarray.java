package google;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tmp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);                          
			result = Math.max(result, max);
		}
		
		return result;
	}
	
	public static void main(String[] rags) {
		MaximumProductSubarray m = new MaximumProductSubarray();
		
//		int[] A = {6, -3, -10, 0, 2};
//		int[] A = {-1, -3, -10, 0, 60};
//		int[] A = {-2, -3, 0, -2, -40};
		int[] A = {-10,0,0,-20,0};                
		System.out.println(m.maxProduct(A));
	}
}

package google;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		
		// find the first i from right to left that violate the increase trend
		int i = nums.length-2;
		while (i >= 0) {
			if (nums[i] < nums[i+1]) {
				break;
			}
			i--;
		}
		
		if (i < 0) {
			reverse(nums, 0, nums.length-1);
			return;
		}
		
		// find the first nums[j] from right to left that larger than nums[i]
		// as [i+1, nums.length-1] are increasing, so actually nums[j] is the smallest element that large than nums[i]
		// and there will be definitely one element that fit above condition as nums[i] < nums[i+1] is how we find the i
		int j = nums.length-1;
		while (j > i && nums[j] <= nums[i]) {
			j--;
		}
		
		// swap them, so the new nums is gurantee larger than the original nums, but it might not be the smallest nums that larger than original one
		swap(nums, i, j);
		
		// reverse [i+1, nums.length-1] to find the smallest nums that larger than original one
		reverse(nums, i+1, nums.length-1);
	}
	
	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			swap(nums, left++, right--);
		}
	}
	
	private void swap(int[] nums, int left, int right) {
		if (left == right) {
			return;
		}
		
		nums[left] = nums[left] ^ nums[right];
		nums[right] = nums[left] ^ nums[right];
		nums[left] = nums[left] ^ nums[right];
	}
	
	public static void main(String[] arsg) {
		int[] nums = {1,5,1};
		NextPermutation n = new NextPermutation();
		n.nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}

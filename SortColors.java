package google;

public class SortColors {
	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int i = 0;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(nums, i++, left++);
			} else if (nums[i] == 1) {
				i++;
			} else {
				// == 2
				swap(nums, i, right--);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
	
	public static void main(String[] args) {
		int[] nums = {2};
		SortColors s = new SortColors();
		s.sortColors(nums);
		
	}
}

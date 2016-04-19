package google;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			// as [left...right] are sorted, so nums[left] is the min element already
			if (nums[left] <= nums[right]) {
				return nums[left];
			}
			
			int mid = (left+right)/2;
			int midleft = mid - 1 < 0 ? nums[nums.length-1] : nums[mid-1];
			int midright = mid + 1 >= nums.length ? nums[0] : nums[mid+1];
			if (midleft >= nums[mid] && nums[mid] <= midright) {
				return nums[mid];
			}
			
			if (nums[left] <= nums[mid]) {
				// [left...mid] are sorted, but nums[left] is not the min element, so lets move to the right
				left = mid + 1;
			} else {
				// [mid...right] are sorted, but nums[mid] is not the min, so lets move to the left
				right = mid - 1;
			}		
		}
		
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,1,2};
		FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
		System.out.println(f.findMin(nums));
	}
}

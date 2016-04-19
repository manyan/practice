package google;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left + right)/2;
			if (nums[mid] == target) {
				return mid;
			}
			
			if (nums[left] <= nums[mid]) {
				// [left...mid] are sorted
				if (nums[left] <= target && target <= nums[mid]) {
					// so we have a chance to find target in this range
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// [mid...right] are sorted
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return -1;
	}
}

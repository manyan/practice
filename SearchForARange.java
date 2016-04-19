package google;
/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * */
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}
		
		int left = findTheLargestOrSmallestElementSmallerThanTarget(nums, target, true);
		// check whether target exist
		if (left+1 >= nums.length || nums[left+1] != target) {
			return new int[] {-1, -1};
		}
		
		int right = findTheLargestOrSmallestElementSmallerThanTarget(nums, target, false);
		return new int[] {left+1, right-1};
	}
	
	// return index
	public int findTheLargestOrSmallestElementSmallerThanTarget(int[] nums, int target, boolean isLargest) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left+right)/2;
			if (isLargest) {
				if (nums[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (nums[mid] <= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return isLargest ? right : left;
	}
}

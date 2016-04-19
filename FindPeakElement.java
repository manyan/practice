package google;

/*
 * 因为num[-1] = num[n] = -∞，所以只要数组中没有连续出现的相同元素，这个peak element就总是存在的。
 * 根据上述条件可以写出二分查找 
 * */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = (left+right)/2;
			int pre = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid-1];
			int next = mid + 1 >= nums.length ? Integer.MIN_VALUE : nums[mid+1];
			if (pre <= nums[mid] && nums[mid] >= next) {
				return mid;
			}
			
			if (pre > nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
}

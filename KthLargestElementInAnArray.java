package google;

public class KthLargestElementInAnArray {
	// basically, its quickselect
	public int findKthLargest(int[] nums, int k) {
		if (k <= 0 || k > nums.length) {
			return Integer.MIN_VALUE;
		}
		
		k = nums.length-k;
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int rank = quickSelect(nums, left, right);
			if (rank == k) {
				break;
			} else if (rank > k) {
				right = k-1;
			} else {
				left = k+1;
			}
		}
		
		return nums[k];
	}
	
	public int quickSelect(int[] nums, int left, int right) {
		if (left >= right) {
			return left;
		}
		
		int p = left;
		int pivot = nums[left];
		for (int i = left+1; i <= right; i++) {
			if (nums[i] < pivot) {
				p++;
				swap(nums, i, p);
			}
		}
		
		swap(nums, left, p);
		return p;
	}
	
	public void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1};
		KthLargestElementInAnArray f = new KthLargestElementInAnArray();
		System.out.println(f.findKthLargest(nums, 1));
	}
}

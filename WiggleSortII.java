package google;

import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		
		Arrays.sort(nums);
		int p1 = 0;
		int p2 = (nums.length - 1) / 2 + 1;
		int[] tmp = new int[nums.length];
		for (int i = 0; i < tmp.length; i++) {
			if ((i&1) == 1) {
				// odd
				tmp[i] = nums[p2++];
			} else {
				tmp[i] = nums[p1++];
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = tmp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,1,2,2,1};
		WiggleSortII w = new WiggleSortII();
		w.wiggleSort(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
}

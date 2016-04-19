package google;

public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		if (k <= 0 || k > nums1.length + nums2.length) {
			return new int[0];
		}
		
		int[] result = new int[k];
		
		for (int len1 = 0; len1 <= k; len1++) {
			int len2 = k-len1;
			if (len1 > nums1.length || len2 > nums2.length) {
				continue;
			}
			
			int[] r1 = max(nums1, len1);
			int[] r2 = max(nums2, len2);
			int[] tmp = new int[k];
			int p1 = 0;
			int p2 = 0;
			int p = 0;
			while (p < tmp.length) {
				tmp[p++] = isGreater(r1, p1, r2, p2) ? r1[p1++] : r2[p2++];
			}
			
			if (isGreater(tmp, 0, result, 0)) {
				result = tmp;
			}
		}
		
		return result;
	}
	
	// return true if, nums1[p1...] > nums2[p2...]
	public boolean isGreater(int[] nums1, int p1, int[] nums2, int p2) {
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] > nums2[p2]) {
				return true;
			}
			if (nums1[p1] < nums2[p2]) {
				return false;
			}
			p1++;
			p2++;
		}
		
		return p1 < nums1.length;
	}
	
	// max integer we can form using number from nums with k len
	public int[] max(int[] nums, int k) {
		if (k <= 0) {
			return new int[0];
		}
		
		if (k == nums.length) {
			return nums;
		}
		
		int[] result = new int[k];
		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			while (p > 0 && result[p-1] < nums[i] && k-p+1 <= nums.length-i) {
				p--;
			}
			
			if (p < k) {
				result[p] = nums[i];
				p++;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
//		int[] nums1 = {8,6,9};
//		int[] nums2 = {1,7,5};
		int[] nums1 = {5,7};
		int[] nums2 = {5,7,1};
		CreateMaximumNumber c = new CreateMaximumNumber();
		int[] result = c.maxNumber(nums1, nums2, 3);
//		int[] result = c.max(nums1, 2);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

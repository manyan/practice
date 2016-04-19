package google;


public class PatchingArray {
	public int minPatches(int[] nums, int n) {
		if (n <= 0) {
			return 0;
		}
		
		// we keep a range of [0, 1), init missing will be 1
		long missing = 1;
		// as the original nums are sorted, and we try to use them one by one in increasing order
		int index = 0; 
		int count = 0;
		
		while (missing <= n) {
			if (index < nums.length && nums[index] <= missing) {
				missing += nums[index];
				index++;
			} else {
				// we already use all the nums but not yet reach the expect range [0, n], so lets keep adding missing to the patch
				missing += missing;
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,31,33};
		PatchingArray p = new PatchingArray();
		System.out.println(p.minPatches(nums, 2147483647));
	}
}

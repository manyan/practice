package google;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		return removeDuplicates(nums, 2);
	}
	
	// max k repeat 
	public int removeDuplicates(int[] nums, int k) {
		int i = 0; 
		int left = 0;
		while (i < nums.length) {
			int val = nums[i++];
			nums[left++] = val;
			int count = 1;
			while (i < nums.length && nums[i] == val) {
				count++;
				i++;
			}
			count = Math.min(count, k);
			while (count > 1) {
				nums[left++] = val;
				count--;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2};
		RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
		System.out.println(r.removeDuplicates(nums));
	}
}

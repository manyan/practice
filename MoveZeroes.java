package google;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		
		int i = 0;
		int p = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				if (i != p) {
					nums[i] = nums[i] ^ nums[p];
					nums[p] = nums[i] ^ nums[p];
					nums[i] = nums[i] ^ nums[p];
				}
				p++;
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		MoveZeroes m = new MoveZeroes();
		m.moveZeroes(nums);
	}
}

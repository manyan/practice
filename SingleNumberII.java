package google;

public class SingleNumberII {
	public int singleNumber(int[] nums) {
		return singleNumber(nums, 3);
	}
	
	// extend to a generic method, every number repeats k times, except one only occur once
	public int singleNumber(int[] nums, int k) {
		int mask = 0;
		int result = 0;
		for (int bit = 0; bit < 32; bit++) {
			mask = 1 << bit;
			int sumOfBits = 0;
			for (int i = 0; i < nums.length; i++) {
				if ((nums[i] & mask) != 0) {
					sumOfBits++;
				}
			}
			
			if ((sumOfBits % 3) != 0) {
				result |= 1 << bit;
			}
		}
		
		return result;
	}
	
	public static int find(int[] A, int repeat) {
		int result = 0;
		for (int i = 0; i <= 31; i++) {
			int sum = 0;
			int mask = 1 << i;
			for (int elem : A) {
				if ((elem & mask) != 0) {
					sum++;
				}
			}
			
			result += (sum%repeat) << i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,-3,-3,-3};
		SingleNumberII s = new SingleNumberII();
		System.out.println(s.singleNumber(nums));
	}
}

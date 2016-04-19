package google;

public class JumpGameII {
	public int jump(int[] nums) {
		if (nums == null) {
			return 0;
		}
		
		int i = 0;
		int count = 0;
		while (i < nums.length) {
			int farest = i + nums[i];
			count++;
			if (farest >= nums.length-1) {
				return count;
			}
			if (farest == i) {
				return Integer.MIN_VALUE; // can not jump
			}
			
			int next = i+1;
			int nextFarest = next;
			int j = next;
			while (j <= farest) {
				int tmp = j + nums[j];
				if (tmp > nextFarest) {
					nextFarest = tmp;
					next = j;
				}
				j++;
			}
			
			if (nextFarest <= farest) {
				return Integer.MIN_VALUE;
			}
			
			i = next;
		}
		
		return Integer.MIN_VALUE;
	}
}

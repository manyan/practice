package google;

public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums == null) {
			return true;
		}
		
		int i = 0;
		while (i < nums.length) {
			int farest = i + nums[i];
			if (farest >= nums.length-1) {
				return true;
			}
			if (farest == i) {
				return false; // can not jump
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
			
			if (nextFarest >= nums.length-1) {
				return true;
			}
			if (nextFarest <= farest) {
				return false;
			}
			
			i = next;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		JumpGame j = new JumpGame();
		int[] nums = {2,0,0};
		System.out.println(j.canJump(nums));
	}
}

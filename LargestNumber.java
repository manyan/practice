package google;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		boolean isAllZero = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				isAllZero = false;
				break;
			}
		}
		
		if (isAllZero) {
			return "0";
		}
		
		quickSort(nums, 0, nums.length-1);
		StringBuilder sb = new StringBuilder();
		for (int i = nums.length-1; i >= 0; i--) {
			sb.append(nums[i]);
		}
		
		return sb.toString();
	}
	
	public void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int p = select(nums, left, right);
		quickSort(nums, left, p-1);
		quickSort(nums, p+1, right);
	}
	
	// actually its a sort
	public int select(int[] nums, int left, int right) {
		if (left >= right) {
			return left;
		}
		
		int pivot = nums[left];
		int p = left;
		for (int i = left+1; i <= right; i++) {
			if (smaller(nums[i], pivot)) {
				p++;
				swap(nums, i, p);
			}
			
		}
		
		swap(nums, left, p);
		
		return p;
	}
	
	public boolean smaller(int num, int pivot) {
		int i = Integer.valueOf(""+num+pivot);
		int j = Integer.valueOf(""+pivot+num);
		return i < j;
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
		int[] nums = {3, 30, 34, 5, 9};
		LargestNumber l = new LargestNumber();
		System.out.println(l.largestNumber(nums));
	}
}

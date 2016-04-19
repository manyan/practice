package google;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] nums = new int[n+1];
		nums[0] = 1;
		nums[1] = 1;
		for (int nodes = 2; nodes <= n; nodes++) {
			for (int root = 1; root <= nodes; root++) {
				int left = nums[root-1];
				int right = nums[nodes - root];
				nums[nodes] += left * right;
			}
		}
		
		return nums[n];
	}
}

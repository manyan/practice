package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		subsets(nums, 0, result, new ArrayList<Integer>());
		return result;
	}
	
	private void subsets(int[] nums, int p, ArrayList<List<Integer>> result, ArrayList<Integer> sol) {
		result.add((ArrayList<Integer>)sol.clone());
		for (int i = p; i < nums.length; i++) {
			sol.add(nums[i]);
			subsets(nums, i+1, result, sol);
			sol.remove(sol.size()-1);
		}
	}
}

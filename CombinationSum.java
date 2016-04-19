package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, 0, result, new ArrayList<Integer>());
		return result;
	}
	
	private void combinationSum(int[] candidates, int target, int p, int sum, ArrayList<List<Integer>> result, ArrayList<Integer> sol) {
		if (sum > target) {
			return;
		}
		
		if (sum == target) {
			result.add((ArrayList<Integer>)sol.clone());
			return;
		}
		
		for (int i = p; i < candidates.length; i++) {
			sol.add(candidates[i]);
			combinationSum(candidates, target, i, sum + candidates[i], result, sol);
			sol.remove(sol.size()-1);
		}
	}
	
	public static void main(String[] args) {
	
	}
}

package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
//	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
//		Arrays.sort(candidates);
//		combinationSum(candidates, target, 0, 0, result, new ArrayList<Integer>());
//		return result;
//	}
//	
//	private void combinationSum(int[] candidates, int target, int p, int sum, ArrayList<List<Integer>> result, ArrayList<Integer> sol) {
//		if (sum > target) {
//			return;
//		}
//		
//		if (sum == target) {
//			result.add((ArrayList<Integer>)sol.clone());
//			return;
//		}
//		
//		for (int i = p; i < candidates.length; i++) {
//			sol.add(candidates[i]);
//			combinationSum(candidates, target, i+1, sum + candidates[i], result, sol);
//			sol.remove(sol.size()-1);
//		}
//	}
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		
		Arrays.sort(num);
		if (num[0] > target) {
			return result;
		}
		
		combination(num, 0, target, 0, result, new ArrayList<Integer>());
		return result;
	}
	
	private void combination(int[] A, int p, int target, int current, ArrayList<List<Integer>> result, ArrayList<Integer> path) {
		if (current == target) {
			result.add((ArrayList<Integer>)path.clone());
			return;
		}
		if (p >= A.length) {
			return;
		}
		
		for (int i = p; i < A.length; i++) {
			if (current + A[i] > target) {
				break;
			}
			
			// skip duplicate
			if (i > p && A[i] == A[i-1]) {
				continue;
			}
			
			path.add(A[i]);
			combination(A, i+1, target, current+A[i], result, path);
			path.remove(path.size()-1);
		}
	}
}

package google;

import java.util.ArrayList;
import java.util.List;

import the.art.of.programming.classes.Utils;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		dfs(1,0,k,n,result, new ArrayList<Integer>());
		return result;
	}
	
	public void dfs(int cur, int sum, int k, int n, List<List<Integer>> result, ArrayList<Integer> sol) {
		if (sum > n || sol.size() > k ) {
			return;
		}
		
		if (sum == n && sol.size() == k) {
			result.add((ArrayList<Integer>)sol.clone());
			return;
		}
		
		// choose cur
		sol.add(cur);
		dfs(cur+1, sum + cur, k, n, result, sol);
		sol.remove(sol.size()-1);
		
		dfs(cur+1, sum, k, n, result, sol);
	}
	
	public static void main(String[] args) {
		CombinationSumIII c = new CombinationSumIII();
		List<List<Integer>> result = c.combinationSum3(3, 7);
		Utils.printList(result);
	}
}

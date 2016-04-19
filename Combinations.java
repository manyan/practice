package google;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		combine(n, k, 1, result, new ArrayList<Integer>());
		return result;
	}
	
	public void combine(int n, int k, int c, ArrayList<List<Integer>> result, ArrayList<Integer> sol) {
		if (sol.size() == k) {
			result.add((ArrayList<Integer>)sol.clone());
			return;
		}
		
		if (c > n) {
			return;
		}
		
		
		// choose the current one
		sol.add(c);
		combine(n, k, c+1, result, sol);
		sol.remove(sol.size()-1);
		
		// does not choose
		combine(n, k, c+1, result, sol);
	}
	
	public static void main(String[] args) {
		Combinations c = new Combinations();
		List<List<Integer>> result = c.combine(1, 1);
		for (List<Integer> sol : result) {
			for (Integer i : sol) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

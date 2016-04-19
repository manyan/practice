package google;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
	// generate all premutation
	public List<List<Integer>> permute(int[] A) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		premutation(A, 0, result);
		return result;
	}
	
	private void premutation(int[] A, int p, List<List<Integer>> result) {
		if (p == A.length) {
			result.add(clone(A));
			return;
		}
		
		for (int i = p; i < A.length; i++) {
			// this is a useful pattern that can remove duplicate
			// i > p means for the first iteration, we need to include them all, but for the next/other iterations, remove duplicate
			// as they are already cover previously
			if (i > p && A[i] == A[i-1]) {
				continue;
			}
			
			swap(A, i, p);
			premutation(A, p+1, result);
			swap(A, i, p);
		}
	}
	
	private void swap(int[] A, int i, int j) {
		if (i == j) {
			return;
		}
		
		A[i] = A[i] ^ A[j];
		A[j] = A[i] ^ A[j];
		A[i] = A[i] ^ A[j];
	}
	
	private List<Integer> clone(int[] A) {
		List<Integer> solution = new LinkedList<Integer>();
		for (int i = 0; i < A.length; i++) {
			solution.add(A[i]);
		}
		return solution;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,2};
		Permutation p = new Permutation();
		List<List<Integer>> result = p.permute(A);
		for (List<Integer> sol : result) {
			for (Integer i : sol) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

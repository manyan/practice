package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// with duplicate
public class PermutationsII {	
	public List<List<Integer>> permuteUnique(int[] A) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(A);
		premutation(A, 0, result, new int[A.length]);
		return result;
	}
	
	private void premutation(int[] A, int p, List<List<Integer>> result, int[] visited) {
		if (p == A.length) {
			result.add(clone(A));
			return;
		}
		
		for (int i = p; i < A.length; i++) {
			// this is the very pattern that we will use for a lot of algorithms to remove duplcate!
			if (i > 0 && A[i] == A[i-1] && visited[i-1] == 1) {
				continue; // remove duplicate
			}
			
			visited[i] = 1;
			swap(A, i, p);
			premutation(A, p+1, result, visited);
			swap(A, i, p);
			visited[i] = 0;
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
//		int[] A = {1,-1,1,2,-1,2,2,-1};
		int[] A = {1,1,2};
		PermutationsII p = new PermutationsII();
		List<List<Integer>> result = p.permuteUnique(A);
		for (List<Integer> sol : result) {
			for (Integer i : sol) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}

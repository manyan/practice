package google;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		// queens[i] = j, means the queen at ith row will be located at col j, both i and j start from 0
		int[] queens = new int[n];
		for (int i = 0; i < n; i++) {
			queens[i] = i;
		}
		List<List<String>> result = new ArrayList<List<String>>();
		solveBasedOnPermutation(queens, 0, result);
		return result;
	}
	
	public void solveBasedOnPermutation(int[] queens, int p, List<List<String>> result) {
		if (p == queens.length) {
			if (isValid(queens)) {
				List<String> sol = new ArrayList<String>();
				for (int i = 0; i < queens.length; i++) {
					char[] chars = getChars(queens.length);
					chars[queens[i]] = 'Q';
					sol.add(String.valueOf(chars));
				}
				result.add(sol);
			}
			return;
		}
		
		// normal permutation loop
		for (int i = p; i < queens.length; i++) {
			swap(queens, i, p);
			solveBasedOnPermutation(queens, p+1, result);
			swap(queens, i, p);
		}
	}
	
	public void swap(int[] A, int i, int j) {
		if (i == j) return;
		A[i] = A[i] ^ A[j];
		A[j] = A[i] ^ A[j];
		A[i] = A[i] ^ A[j];
	}
	
	public boolean isValid(int[] queens) {
		// just need to check diagonal
		for (int i = 0; i < queens.length; i++) {
			int col = queens[i];
			// we only need to check diagonal below, as the ones above the current row has been check by the row above already
			for (int j = i+1; j < queens.length; j++) {
				if (j - i == Math.abs(queens[j] - col)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private char[] getChars(int n) {
		char[] chars = new char[n];
		for (int i = 0; i < n; i++) {
			chars[i] = '.';
		}
		return chars;
	}
	
	// is it valid to set queens[row] = col
	public boolean isValid(int[] queens, int row, int col) {
		// no need to check row as we only put one queen in one row
		for (int i = 0; i < queens.length; i++) { 
			if (i == row || queens[i] == -1) {
				continue;
			}
			
			// check both col and diagonal
			if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		NQueens n = new NQueens();
		List<List<String>> result = n.solveNQueens(9);
		for (List<String> sol : result) {
			for (String s : sol) {
				System.out.println(s);
			}
			System.out.println("///////////////////////");
		}
	}
}

package google;

import java.util.HashSet;
import java.util.Set;

/*
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * 
 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 * */
public class FindDuplicates {
	public Set<Integer> findDuplicate(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			while (A[i] != i && A[A[i]] != A[i]) {
				int j = A[i];
				// swap i and j
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
			
			if (A[i] != i) {
				// duplicate
				set.add(A[i]);
			}
		}
		
		return set;
	}
	
	public static void main(String[] args) {
		FindDuplicates f = new FindDuplicates();
		int[] A = {1, 2, 3, 1, 3, 6, 6};
		Set<Integer> set = f.findDuplicate(A);
		for (int i : set) {
			System.out.print(i + " ");
		}
	}
}

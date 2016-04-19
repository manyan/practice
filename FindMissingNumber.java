package google;
/*
 * http://www.geeksforgeeks.org/find-lost-element-from-a-duplicated-array/
 * 
 * */
public class FindMissingNumber {
	// also work for not sorted array
	public int find(int[] A, int[] B) {
		// make sure A is the longer
		if (A.length < B.length) {
			int[] tmp = A;
			A = B;
			B = tmp;
		}
		
		int l1 = 0;
		int r1 = A.length-1;
		int l2 = 0;
		int r2 = B.length-1;
		
		while (l1 <= r1 && l2 <= r2) {
			int m1 = (l1+r1)/2;
			int m2 = (l2+r2)/2;
			if (A[m1] == B[m2]) {
				 if (r1-m1 > r2-m2) {
					 l1 = m1+1;
					 l2 = m2+1;
				 } else {
					 r1 = m1-1;
					 r2 = m2-1;
				 }
			} else {
//				if (A[m1] > B[m2]) {
//					int nextB = m2 + 1 < B.length ? B[m2+1] : Integer.MAX_VALUE;
//					if (nextB == Integer.MAX_VALUE || A[m1] != nextB) {
//						return A[m1];
//					} else {
//						l1 = m1+1;
//						l2 = m2+2;
//					}
//				} else {
//					int preB = m2 - 1 >= 0 ? B[m2-1] : Integer.MIN_VALUE;
//					if (preB == Integer.MIN_VALUE || preB != A[m1]) {
//						return A[m1];
//					} else {
//						r1 = m1-1;
//						r2 = m1-2;
//					}
//				}
				
				// comment out above as there is not change to go to the left part in this condition
				int nextB = m2 + 1 < B.length ? B[m2+1] : Integer.MAX_VALUE;
				if (nextB == Integer.MAX_VALUE || A[m1] != nextB) {
					return A[m1];
				} else {
					l1 = m1+1;
					l2 = m2+2;
				}
			}
		}
		
		return A[l1 <= r1 ? l1 : r1];
	}
	
	public static void main(String[] arsg) {
		FindMissingNumber f = new FindMissingNumber();
		
//		int[] B = {1, 4, 5, 7, 9};
//		int[] A = {4, 5, 7, 9};
		
		int[] A = {2, 3, 4, 6};
	    int[] B = {2, 3, 4, 5, 6};
		
		System.out.println(f.find(A, B));
	}
}

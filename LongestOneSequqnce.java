package google;
/*
 * 
 * http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 * 
 * 2. Given an array of 0s and 1s . I was asked to return the index of a zero turning which will produce a longest continuous 1s.

Ex 1 0 1 1 0 1 0 1 1 1 0 1. here turning the last 0 to 1 will form 5 ones. this is the longest of all.
 * 
 * */
public class LongestOneSequqnce {
	public int find(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int turnPosition = -1;
		int leftMostOnePosition = -1;
		int max = 0;
		int position = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				if (leftMostOnePosition == -1) {
					leftMostOnePosition = i;
				}
				
				if (i - leftMostOnePosition + 1 > max) {
					max = i - leftMostOnePosition + 1;
					if (turnPosition != -1) {
						// mark it down
						position = turnPosition;
					}
				}
			} else {
				// lets turn the current zero to one
				turnPosition = i;
				
				// have not met any one yet
				if (leftMostOnePosition == -1) {
					if (max == 0) {
						max = 1;
						position =i;
					}
				} else {
					// turn the current zeor to one
					if (i - leftMostOnePosition + 1 > max) {
						max = i - leftMostOnePosition + 1;
						position = turnPosition;
					}
				}
			}
		}
		
		return position;
	}
	
	public static void main(String[] rags) {
		int[] A = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
//		int[] A = {0,0,0,1,1,0};
//		int[] A = {0,0,0,0,0};
		LongestOneSequqnce l = new LongestOneSequqnce();
		System.out.println(l.find(A));
	}
}

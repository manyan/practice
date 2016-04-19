package google;
/*
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.

We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem, try yourself first.

We measure the complexity in terms of calls made to HaveAcquaintance().
 * */
public class CelebrityProblem {
	// this is the given method
	public boolean HaveAcquaintance(int i, int j) {
		return true; // lets just call it dummy
	}
	
	/*
	 * better version that the geeksforgeeks as we do not need a stack at all
	 * just keep 2 pointer, and each time, we eliminate one
	 * */ 
	public int find(int[] A) {
		int left = 0;
		int right = A.length-1;
		while (left < right) {
			// if A[left] knows A[right], A[left] is definitely not celebrity
			if (HaveAcquaintance(A[left], A[right])) {
				left++;
			} else {
				// if A[left] does not know A[right], A[right] is definitely not celebrity
				right--;
			}
		}
		
		// when above loop break, we have left == right, we still need to verify whether its actually the celebirty
		for (int i = 0; i < A.length; i++) {
			if (i == left) {
				continue;
			}
			
			// A[i] knows A[left] and A[left] does not know A[i], 
			if (HaveAcquaintance(A[i], A[left]) && !HaveAcquaintance(A[left], A[i])) {
				continue;
			}
			
			return Integer.MIN_VALUE;
		}
		
		return A[left];
	}
}

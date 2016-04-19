package google;

public class FindMinimumInRotatedSortedArrayWithDuplicates {
	public int findMin(int[] A) {
		if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int left = 0;
		int right = A.length-1;
		while (left <= right) {
			if (left == right) {
				return A[left];
			}
			
			// use <, not <=, the only diff between this a the one without duplicates
			if (A[left] < A[right]) {
				return A[left];
			}
			
			int mid = (left+right)/2;
			int midleft = mid - 1 < 0 ? A[A.length-1] : A[mid-1];
			int midright = mid + 1 >= A.length ? A[0] : A[mid+1];
			// again not =
			if (midleft > A[mid] && A[mid] < midright) {
				return A[mid];
			}
			
			if (A[left] < A[mid]) {
				// [left...mid] is sorted
				// left = mid, not left = mid + 1, its because A[mid] might be the smallest!
				// consider A = {2,2,2,0,0,1}, and left = 1, right = 5, mid = 3.
				left = mid;
			} else if (A[mid] < A[right]) {
				// [mid...right] is sorted, right = mid!
				right = mid;
			} else {
				// reduce the range
				left++;
			}
		}
		
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] A = {2,2,2,0,0,1};
		FindMinimumInRotatedSortedArrayWithDuplicates f = new FindMinimumInRotatedSortedArrayWithDuplicates();
		System.out.println(f.findMin(A));
	}
}

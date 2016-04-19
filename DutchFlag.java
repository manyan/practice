package google;

public class DutchFlag {
	// A only contains 0,1,2
	public void sort(int[] A) {
		int i = 0;
		int right = A.length-1;
		int left = 0;
		while (i <= right) {
			if (A[i] == 0) {
				swap(A, i, left);
				i++;
				left++;
			}else if (A[i] == 1) {
				i++;
			} else {
				// A[i] == 2
				swap(A, i, right);
				right--;
			}
		}
	}
	
	public void swap(int[] A, int i, int j) {
		if (i == j) {
			return;
		}
		
		A[i] = A[i] ^ A[j];
		A[j] = A[i] ^ A[j];
		A[i] = A[i] ^ A[j];
	}
	
	public static void main(String[] args) {
		DutchFlag d = new DutchFlag();
		
		int[] A = {1,0,0,1,0,2,0,2,2,1,0};
		d.sort(A);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}
}


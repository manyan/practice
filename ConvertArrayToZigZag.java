package google;
/*
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * */
public class ConvertArrayToZigZag {
	public void convert(int[] A) {
		if (A == null) {
			return;
		}
		
		for (int i = 0; i < A.length-1; i++) {
			if ((i%2) == 0 && A[i] > A[i+1] || (i%2) == 1 && A[i] < A[i+1]) {
				A[i] = A[i] ^ A[i+1];
				A[i+1] = A[i] ^ A[i+1];
				A[i] = A[i] ^ A[i+1];
			} 
		}
	}
	
	public static void main(String[] args) {
		int[] A = {4, 3, 7, 8, 6, 2, 1};
		ConvertArrayToZigZag c = new ConvertArrayToZigZag();
		c.convert(A);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}
}

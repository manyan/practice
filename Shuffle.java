package google;

public class Shuffle {
	public void shuffle(int[] A) {
		for (int last = A.length-1; last > 0; last--) {
			int i = (int)(Math.random() * (last+1));
			if (i == last) {
				continue;
			}
			
			A[last] = A[last] ^ A[i];
			A[i] = A[last] ^ A[i];
			A[last] = A[last] ^ A[i];
		}
	}
}

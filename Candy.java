package google;

public class Candy {
	public int candy(int[] ratings) {
		int[] left = new int[ratings.length];
		left[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				left[i] = 1 + left[i-1];
			} else {
				left[i] = 1;
			}
		}
		
		// check from the right
		int total = left[ratings.length-1];
		for (int i = ratings.length-2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1] && left[i] <= left[i+1] ) {
				left[i] = left[i+1] + 1;
			}
			total += left[i];
		}
		
		return total;
	}
}

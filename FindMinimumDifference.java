package google;
/*
 * http://www.geeksforgeeks.org/find-minimum-difference-pair/
 * */
public class FindMinimumDifference {
	public int minDistance(int[] arr, int num1, int num2) {
		int candidateP = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num1 || arr[i] == num2) {
				if (candidateP != -1 && arr[candidateP] != arr[i]) {
					// found one possibility
					min = Math.min(i - candidateP, min);
				}
				
				candidateP = i;
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		FindMinimumDifference f = new FindMinimumDifference();
		int[] arr = {1, 19, -4, 31, 38, 1, 25, 100};
		System.out.println(f.minDistance(arr, 31, 1));
	}
}

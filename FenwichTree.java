package google;

/*
 * suitable use case: range sum with update operations
 * update: O(lgn)
 * sum: O(lgn)
 * 
 * */
public class FenwichTree {
	int[] original;
	int[] BIS; // fenwich tree aslo called binary indexed tree, its not a binary tree! its a binary indexed tree
	
	public FenwichTree(int[] input) {
		original = input;
		BIS = new int[input.length+1];
		for (int i = 0; i < input.length; i++) {
			update(i, original[i]);
		}
	}
	
	// original[index] += diff
	public void update(int index, int diff) {
		index++; // convert it to BIS index, which is also +1
		while (index < BIS.length) {
			BIS[index] += diff;
			index = getNext(index);
		}
	}
	
	// find the sum of original[i...j]
	public int sum(int i, int j) {
		return sum(j) - sum(i-1);
	}
	
	// find the sum of original[0...index]
	private int sum(int index) {
		index++;
		int sum = 0;
		while (index > 0) {
			sum += BIS[index];
			index = getParent(index);
		}
		
		return sum;
	}
	
	// index & (-index) == rightmost set bit, basically, parent == index - (right most set bit)
	// be sure that the index is BIS index, not the index for original array
	private int getParent(int index) {
		return index - (index & (-index));
	}
	
	private int getNext(int index) {
		return index + (index & (-index));
	}
	
	public static void main(String[] args) {
		int[] A = {3,-1,3,1,2,5};
		FenwichTree f = new FenwichTree(A);
		System.out.println(f.sum(0, 2));
	}
}

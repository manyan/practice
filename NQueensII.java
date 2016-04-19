package google;


public class NQueensII {
	public int nqueen(int n) {
		if (n <= 0) {
			return 0;
		}
		
		int[] queens = new int[n];
		for (int i = 0; i < queens.length; i++) {
			queens[i] = -1;
		}
		
		return nqueen(queens, 0);
	}
	
	public int nqueen(int[] queens, int row) {
		if (row == queens.length) {
			return 1;
		}
		
		int sum = 0;
		for (int col = 0; col < queens.length; col++) {
			if (isOK(queens, row, col)) {
				queens[row] = col;
				sum += nqueen(queens, row+1);
				queens[row] = -1;
			}
		}
		
		return sum;
	}
	
	public boolean isOK(int[] queens, int row, int col) {
		for (int i = 0; i < queens.length; i++) {
			if (row != i && queens[row] != -1 && (queens[row] != col || Math.abs(row - i) == Math.abs(col - queens[i]))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		NQueensII n = new NQueensII();
		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " : " + n.totalNQueens(i));
		}
	} 
	
	public int totalNQueens(int n) {
		if (n <= 0) {
			return 0;
		}
		
		int[] position = new int[n];
		for (int i = 0; i < n; i++) {
			position[i] = -1;
		}
		
		return total(position, 0);
	}
	
	public int total(int[] position, int row) {
		if (row == position.length) {
			return 1; // found one
		}
		
		int sum = 0;
		for (int col = 0; col < position.length; col++) {
			position[row] = col;
			if (isOk(position, row, col)) {
				sum += total(position, row+1);
			}
			position[row] = -1;
		}
		
		return sum;
	}
	
	// check whether its ok to add a queen at [row, col]
	public boolean isOk (int[] position, int row, int col) {
		for (int i = 0; i < position.length; i++) {
			if (i != row && position[i] != -1 && (position[i] == col || Math.abs(i-row) == Math.abs(position[row]) - col)) {
				return false;
			}
		}
		
		return true;
	}
}

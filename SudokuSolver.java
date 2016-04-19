package google;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board);
	}

	private boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					continue;
				}
				// now we need to fill in a number into the current cell
				for (int num = 1; num <= 9; num++) {
					board[i][j] = (char) ('0' + num);
					if (isValid(board, i, j) && solve(board)) {
						return true;
					}
					board[i][j] = '.';
				}
				return false;
			}
		}

		return true;
	}

	// by adding a val into [row, col], we need to verify whether its still
	// valid
	private boolean isValid(char[][] board, int row, int col) {
		boolean[] valid = new boolean[9];
		// check for row
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == '.') {
				continue;
			}

			int index = board[row][i] - '1';
			if (valid[index]) {
				return false;
			}
			valid[index] = true;
		}

		// reset valid
		for (int i = 0; i < 9; i++) {
			valid[i] = false;
		}

		// check for col
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == '.') {
				continue;
			}
			int index = board[i][col] - '1';
			if (valid[index]) {
				return false;
			}
			valid[index] = true;
		}

		// reset valid
		for (int i = 0; i < 9; i++) {
			valid[i] = false;
		}

		row = (row / 3) * 3;
		col = (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row + i][col + j] == '.') {
					continue;
				}
				
				int index = board[row + i][col + j] - '1';
				if (valid[index]) {
					return false;
				}
				valid[index] = true;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		char[][] board = { "..9748...".toCharArray(),
				"7........".toCharArray(), ".2.1.9...".toCharArray(),
				"..7...24.".toCharArray(), ".64.1.59.".toCharArray(),
				".98...3..".toCharArray(), "...8.3.2.".toCharArray(),
				"........6".toCharArray(), "...2759..".toCharArray() };
		SudokuSolver s = new SudokuSolver();
		s.solveSudoku(board);
	}
}

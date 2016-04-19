package google;

import java.util.Stack;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}
			if (board[board.length-1][i] == 'O') {
				dfs(board, board.length-1, i);
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][board[0].length-1] == 'O') {
				dfs(board, i, board[0].length-1);
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '1') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}
	
	public void dfs(char[][] board, int i, int j) {
		Stack<Position> stack = new Stack<Position>();
		stack.push(new Position(i, j));
		while (!stack.isEmpty()) {
			Position cur = stack.pop();
			board[cur.row][cur.col] = '1';
			if (cur.row - 1 >= 0 && board[cur.row-1][cur.col] == 'O') {
				stack.push(new Position(cur.row-1, cur.col));
			}
			if (cur.col - 1 >= 0 && board[cur.row][cur.col-1] == 'O') {
				stack.push(new Position(cur.row, cur.col-1));
			}
			if (cur.row+1 < board.length && board[cur.row+1][cur.col] == 'O') {
				stack.push(new Position(cur.row+1, cur.col));
			}
			if (cur.col+1 < board[0].length && board[cur.row][cur.col+1] == 'O') {
				stack.push(new Position(cur.row, cur.col+1));
			}
		}
	}
	
	public class Position {
		int row;
		int col;
		
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}

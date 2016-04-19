package google;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int row = word1.length()+1;
		int col = word2.length()+1;
		int[][] dis = new int[row][col];
		for (int i = 1; i < row; i++) {
			dis[i][0] = i;
		}
		for (int i = 1; i < col; i++) {
			dis[0][i] = i;
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
//				dis[i][j] = Math.min(dis[i-1][j], dis[i][j-1]) + 1;
//				dis[i][j] = Math.min(dis[i][j], dis[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
//				
//				int min = Math.min(matrix[i-1][j], matrix[i][j-1]) + 1;
//        		min = Math.min(min, matrix[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
//        		matrix[i][j] = min;
				int min = Math.min(dis[i-1][j], dis[i][j-1]) + 1;
				min = Math.min(min, dis[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
				dis[i][j] = min;
			}
		}
		
		return dis[row-1][col-1];
	}
	
	public static void main(String[] args) {
		EditDistance e = new EditDistance();
		System.out.println(e.minDistance("a", "ab"));
	}
}

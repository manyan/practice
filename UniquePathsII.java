package google;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
			return 0;
		}
		
		int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
		// init top row
		for (int i = 0; i < obstacleGrid[0].length; i++) {
			if (obstacleGrid[0][i] == 1) {
				break;
			}
			path[0][i] = 1;
		}
		
		for (int i = 0; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			path[i][0] = 1;
		}
		
		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					path[i][j] = 0;
				} else {
					path[i][j] = path[i-1][j] + path[i][j-1];
				}
			}
		}
		
		return path[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
}

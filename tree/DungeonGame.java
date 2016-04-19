package google.tree;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
		
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] matrix = new int[row][col];
		 // init right bottom
		matrix[row-1][col-1] = 1 - (dungeon[row-1][col-1] < 0 ? dungeon[row-1][col-1] : 0);
		// init right col
		for (int i = row-2; i >= 0; i--) {
			matrix[i][col-1] = matrix[i+1][col-1] - dungeon[i][col-1];
			if (matrix[i][col-1] <= 0) {
				matrix[i][col-1] = 1;
			}
		}
		
		// init bottom row
		for (int i = col-2; i >= 0; i--) {
			matrix[row-1][i] = matrix[row-1][i+1] - dungeon[row-1][i];
			if (matrix[row-1][i] <= 0) {
				matrix[row-1][i] = 1;
			}
		}
		
		for (int i = row-2; i >= 0; i--) {
			for (int j = col-2; j >= 0; j--) {
				matrix[i][j] = Math.min(matrix[i+1][j], matrix[i][j+1]) - dungeon[i][j];
				if (matrix[i][j] <= 0) {
					matrix[i][j] = 1;
				}
			}
		}
		
		return matrix[0][0];
	}
	
	public int find(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] lessBlood = new int[row][col];
        lessBlood[row-1][col-1] = dungeon[row-1][col-1] >= 0 ? 1 : 1 - dungeon[row-1][col-1];
        for (int i = row-2; i >= 0; i--) {
            lessBlood[i][col-1] = Math.max(1, lessBlood[i+1][col-1] - dungeon[i][col-1]);
        }
        for (int i = col-2; i >= 0; i--) {
            lessBlood[row-1][i] = Math.max(1, lessBlood[row-1][i+1] - dungeon[row-1][i]);
        }
        
        for (int i = row-2; i >= 0; i--) {
            for (int j = col-2; j >= 0; j--) {
                lessBlood[i][j] = Math.max(1, Math.min(lessBlood[i+1][j], lessBlood[i][j+1]) - dungeon[i][j]);
            }
        }
        
        return lessBlood[0][0];
	}
}

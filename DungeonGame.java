package google;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
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

package google;
/*
 * To calculate the shortest path for all the pairs for weighted + directed graph
 * */
public class FloydWarshall {
	public int[][] shortestPath(int[][] graph) {
		int[][] result = new int[graph.length][graph[0].length];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				result[i][j] = graph[i][j];
			}
		}
		
		for (int k = 0; k < graph.length; k++) {
			// k as the intermediate node
			for (int i = 0; i < graph.length; i++) {
				// i as the source node
				for (int j = 0; j < graph.length; j++) {
					if (result[i][k] != Integer.MAX_VALUE || result[k][j] != Integer.MAX_VALUE) {
						result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
					}
				}
			}
		}
		
		return result;
	}
}

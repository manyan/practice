package google;

import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> preLine = triangle.get(i-1);
			List<Integer> curLine = triangle.get(i);
			for (int j = 0; j < curLine.size(); j++) {
				int adjLeft = j-1 < 0 ? Integer.MAX_VALUE : preLine.get(j-1);
				int adjRight = j == preLine.size() ? Integer.MAX_VALUE : preLine.get(j);
				curLine.set(j, curLine.get(j) + Math.min(adjLeft, adjRight));
			}
		}
		
		int min = Integer.MAX_VALUE;
		List<Integer> last = triangle.get(triangle.size()-1);
		for (int i : last) {
			min = Math.min(min, i);
		}
		return min;
	}
}

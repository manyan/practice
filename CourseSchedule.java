package google;

import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
	/*
	 * just detect cycle
	 * */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (!map.containsKey(i) && !canFinish(i, prerequisites, map)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean canFinish(int course, int[][] prerequisites, Map<Integer, Integer> map) {
		// 1 as in process, 2 as finished
		map.put(course, 1);
		for (int i = 0; i < prerequisites.length; i++) {
			int to = prerequisites[i][0];
			int from = prerequisites[i][1];
			if (from != course) {
				continue;
			}
			
			// cycle detected
			if (map.containsKey(to) ) {
				if (map.get(to) == 1) {
					return false;
				}
				
				// cur is 2, so lets continue
				continue;
			}
			
			if (!canFinish(to, prerequisites, map)) {
				return false;
			}
		}
		
		map.put(course, 2);
		return true;
	}
}

package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (!map.containsKey(i) && !topologySort(i, prerequisites, map, stack)) {
				return new int[0]; // can not finish
			}
		}
		
		int[] result = new int[numCourses];
		int i = 0;
		while (!stack.isEmpty()) {
			result[i++] = stack.pop();
		}
		
		return result;
	}
	
	public boolean topologySort(int course, int[][] prerequisites, Map<Integer, Integer> map, Stack<Integer> stack) {
		map.put(course, 1);
		
		for (int i = 0; i < prerequisites.length; i++) {
			int from = prerequisites[i][1];
			int to = prerequisites[i][0];
			
			if (from != course) {
				continue;
			}
			
			if (map.containsKey(to)) {
				if (map.get(to) == 1) {
					return false;
				}
				
				// so to's color is 2 as black, lets continue
				continue;
			}
			
			if (!topologySort(to, prerequisites, map, stack)) {
				return false;
			}
		}
		
		map.put(course, 2);
		stack.add(course);
		
		return true;
	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}};
		CourseScheduleII c = new CourseScheduleII();
		int[] result = c.findOrder(2, prerequisites);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

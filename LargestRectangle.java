package google;

import java.util.Stack;

// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class LargestRectangle {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		int tmp = 0;
		while(i < heights.length) {
			while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
				int h = heights[stack.pop()];
				tmp = h * (stack.isEmpty() ? i : i - stack.peek() - 1);
				max = Math.max(tmp, max);
			}
			
			stack.push(i++);
		}
		
		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			tmp = h * (stack.isEmpty() ? i : i - stack.peek() - 1);
			max = Math.max(tmp, max);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] heights = {9,0};
		LargestRectangle l = new LargestRectangle();
		System.out.println(l.largestRectangleArea(heights));
	}
}

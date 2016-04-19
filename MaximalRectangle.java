package google;

import java.util.Stack;

/*
 * very similar to largest rectangle in histragram
 * */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int[] heights = new int[matrix[0].length];
		// init
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int val = matrix[i][j] - '0';
				if (val == 0) {
					heights[j] = 0;
				} else {
					heights[j] += 1;
				}
			}
			
			max = Math.max(max, largestRectangleArea(heights));
		}
		return max;
	}
	
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
		char[][] matrix = {"000".toCharArray(),"000".toCharArray(),"000".toCharArray(),"000".toCharArray()};
		MaximalRectangle m = new MaximalRectangle();
		System.out.println(m.maximalRectangle(matrix));
	}
}

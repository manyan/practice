package google;


/*
 * same as max histogram
 * */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length-1;
		int max = 0;
		while (left < right) {
			int tmp = (right - left) * Math.min(height[left], height[right]);
			max = Math.max(max, tmp);
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return max;
	}
}

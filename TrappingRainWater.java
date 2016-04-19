package google;

public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length <= 2) {
			return 0;
		}

		int[] max = new int[height.length];
		max[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			max[i] = Math.max(max[i - 1], height[i]);
		}

		int rightMax = height[height.length - 1];
		int sum = 0;
		for (int i = height.length - 2; i >= 0; i--) {
			rightMax = Math.max(rightMax, height[i]);
			sum += Math.min(rightMax, max[i]) - height[i];
		}

		return sum;
	}
}

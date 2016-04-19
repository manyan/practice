package google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import the.art.of.programming.classes.Utils;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		for (int first = 0; first < nums.length-2; first++) {
			if (nums[first] > 0) {
				break;
			}
			if (first > 0 && nums[first] == nums[first-1]) {
				continue; // remove duplicate
			}
			
			int second = first+1;
			int third = nums.length-1;
			int remainder = 0 - nums[first];
			while (second < third) {
				int sum = nums[second] + nums[third];
				if (sum == remainder) {
					// found a solution
					List<Integer> sol = new LinkedList<Integer>();
					sol.add(nums[first]);
					sol.add(nums[second]);
					sol.add(nums[third]);
					result.add(sol);
					second++; // keep search
				} else if (sum > remainder) {
					third--;
				} else {
					second++;
				}
			}
		}
		
		return result;
	}
	
	public List<List<Integer>> threeSumBySet(int[] nums, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		for (int first = 0; first < nums.length-2; first++) {
			int tmp = target - nums[first];
			Set<Integer> seen = new HashSet<Integer>();
			for (int third = first+1; third < nums.length; third++) {
				int remainder = tmp - nums[third];
				if (seen.contains(remainder)) {
					// found!
					List<Integer> sol = new LinkedList<Integer>();
					sol.add(nums[first]);
					sol.add(remainder);
					sol.add(nums[third]);
					result.add(sol);
				}
				seen.add(nums[third]);
			}
		}
		
		return result;
	}
	
	// need to sort
	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		for (int first = 0; first < nums.length-2; first++) {
			if (3 * nums[first] > target) {
				break;
			}
			
			int second = first+1;
			if (nums[first] == nums[second]) {
				continue; // remove duplicate
			}
			
			int third = nums.length-1;
			int remainder = target - nums[first];
			while (second < third) {
				int sum = nums[second] + nums[third];
				if (sum == remainder) {
					// found a solution
					List<Integer> sol = new LinkedList<Integer>();
					sol.add(nums[first]);
					sol.add(nums[second]);
					sol.add(nums[third]);
					result.add(sol);
					second++; // keep search
				} else if (sum > remainder) {
					third--;
				} else {
					second++;
				}
			}
		}
		
		return result;
	} 
	
	public static void main(String[] args) {
		int[] nums = {0,0,0};
		ThreeSum t = new ThreeSum();
		List<List<Integer>> result = t.threeSum(nums);
		Utils.printArrayList(result);
	}
}

package google;

public class GasStation {
	// exceed time limit,O(N*N)
	public int canCompleteCircuitETL(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			// start at i station
			int remaind = 0;
			int cur = i;
			int step = 0;
			while (step <= gas.length) {
				int index = cur%gas.length;
				remaind += gas[index];
				if (remaind < cost[index]) {
					break;
				} else {
					cur++;
					step++;
					remaind -= cost[index];
				}
			}
			
			if (step > gas.length) {
				return i;
			}
		}
		
		return -1;
	}
	
	// O(n)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int remaind = 0;
		int cur = 0;
		int reset = 0;
		int start = 0;
		int L = gas.length;
		while (reset < L) {
			remaind += gas[cur] - cost[cur];
			cur = (++cur)%L;
			if (remaind < 0) {
				// can not reach the next station, reset, and lets start from cur 
				start = cur;
				reset++;
				remaind = 0;
				continue;
			}
			
			if (start == cur) {
				return start;
			}
		}
		
		return -1;
	}
	
	// another O(n)
	public int canCompleteCircuitV2(int[] gas, int[] cost) {
		int remain = 0;
		int total = 0;
		int index = 0;
		for (int i = 0; i < gas.length; i++) {
			remain += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (remain < 0) {
				// reset
				remain = 0;
				// start from i+1
				index = i+1;
			}
		}
		
		if (total < 0) {
			return -1;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] gas = {2,4};
		int[] cost = {3,4};
		GasStation g = new GasStation();
		System.out.println(g.canCompleteCircuit(gas, cost));
	}
}

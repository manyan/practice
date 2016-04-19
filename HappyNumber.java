package google;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<Integer>();
		while (n != 1) {
			if (seen.contains(n)) {
				return false;
			}

			seen.add(n);
			int next = 0;
			while (n != 0) {
				next += (n % 10) * (n % 10);
				n /= 10;
			}

			n = next;
		}

		return true;
	}
}

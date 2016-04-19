package google;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		for (Interval inter : intervals) {
			if (isOVerlap(inter, newInterval)) {
				newInterval.start = Math.min(inter.start, newInterval.start);
				newInterval.end = Math.max(inter.end, newInterval.end);
			} else {
				result.add(inter);
			}
		}
		
		// now lets insert the newInterval
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).start > newInterval.start) {
				result.add(i, newInterval);
				newInterval = null;
				break;
			}
		}
		
		if (newInterval != null) {
			result.add(newInterval);
		}
		
		return result;
	}
	
	public boolean isOVerlap(Interval i1, Interval i2) {
		int start = Math.max(i1.start, i2.start);
		int end = Math.min(i1.end, i2.end);
		return start <= end;
	}
}

package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
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

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		
		Interval[] inters = new Interval[intervals.size()];
		Arrays.sort(intervals.toArray(inters),
				new Comparator<Interval>() {
					@Override
					public int compare(Interval i1, Interval i2) {
						return i1.start == i2.start ? i1.end - i2.end
								: i1.start - i2.start;
					}
				});
		
		Interval cur = inters[0];
		for (int i = 1; i < inters.length; i++) {
			Interval inter = inters[i];
			if (cur.end >= inter.start) {
				// overlap
				cur.end = Math.max(inter.end, cur.end);
			} else {
				// merge the cur
				result.add(cur);
				cur = inter;
			}
		}

		result.add(cur);
		return result;
	}
}

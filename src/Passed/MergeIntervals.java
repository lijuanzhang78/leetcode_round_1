package Passed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	  public List<Interval> merge(List<Interval> intervals) {
	        List<Interval> result = new ArrayList<Interval>();
	        if (intervals == null || intervals.size() == 0) return result;
	        
	        Collections.sort(intervals, new Comparator<Interval>() {
	            public int compare(Interval a, Interval b) {
	                return a.start - b.start;
	            }
	        });
	        
	        int start = intervals.get(0).start;
	        int end = intervals.get(0).end;
	        
	        for(Interval interval : intervals) {
	            if (interval.start <= end) {
	                end = Math.max(end, interval.end);
	            } else {
	                result.add(new Interval(start, end));
	                start = interval.start;
	                end = interval.end;
	            
	            }
	        }
	        result.add(new Interval(start, end));
	        return result;
	    }
}

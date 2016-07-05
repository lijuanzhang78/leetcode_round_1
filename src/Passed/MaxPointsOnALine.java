package Passed;

import java.util.HashMap;

public class MaxPointsOnALine {
	  public int maxPoints(Point[] points) {
	        if (points == null || points.length == 0) return 0;
	        if (points.length == 1) return 1;
	        
	        int max = 1;
	        for(int i = 0; i < points.length; i++) {
	            HashMap<Float, Integer> map = new HashMap<>();
	            int localmax = 1;
	            int same = 0;
	            for(int j = 0; j < points.length; j++) {
	                if (j == i) continue;
	                if (points[i].x == points[j].x && points[i].y == points[j].y) {
	                    same++;
	                    continue;
	                }
	                float slope = (float) (points[j].y - points[i].y) / (points[j].x - points[i].x);
	                if (map.containsKey(slope)) {
	                    map.put(slope, map.get(slope) + 1);
	                } else {
	                    map.put(slope, 2);
	                }
	            }
	            
	            for (Integer value : map.values()) { 
	                localmax = Math.max(localmax, value);
	            }
	            localmax += same;
	            max = Math.max(max, localmax);
	        }
	        return max;
	    }

}

package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(prerequisites == null || numCourses == 0 || prerequisites.length == 0) {
	            return true;
	        }
	        
	        int[] visit = new int[numCourses];
	        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	        
	        for(int i=0; i<prerequisites.length; i++) {
	            if(!map.containsKey(prerequisites[i][0])) {
	                ArrayList<Integer> list = new ArrayList<Integer>();
	                list.add(prerequisites[i][1]);
	                map.put(prerequisites[i][0],list);
	            } else {
	                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
	            }
	        }
	        
	        for(int i=0; i<numCourses; i++) {
	            if(visit[i] == 0) {
	                if(!dfs_visit(map,visit,i)) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    
	    boolean dfs_visit(Map<Integer,ArrayList<Integer>> map, int[] visit, int i) {
	        if(visit[i] == -1) {
	            return false;
	        }
	        if(visit[i] == 1) {
	            return true;
	        }
	        visit[i] = -1;
	        
	        if(map.containsKey(i)) {
	            for(int j : map.get(i)) {
	                if(!dfs_visit(map,visit,j)) {
	                    return false;
	                }
	            }
	        }
	        
	        visit[i] = 1;
	        return true;
	    }
}

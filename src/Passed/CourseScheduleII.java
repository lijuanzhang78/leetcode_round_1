package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseScheduleII {
    private int label;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) {
            return new int[0];
        }
        this.label = numCourses - 1;
        int[] result = new int[numCourses];
        
        if(prerequisites == null || prerequisites.length == 0) {
            for(int i=0; i<numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int[] edge : prerequisites) {
            if(map.containsKey(edge[1])) {
                ArrayList<Integer> neighbors = map.get(edge[1]);
                neighbors.add(edge[0]);
                map.put(edge[1], neighbors);
            } else {
                ArrayList<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[0]);
                map.put(edge[1], neighbors);
            }
        }
        
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0) {
                if(!dfs(map, visited, i, result)) {
                    return new int[0];
                }
            }
        }
        
        return result;
    }
    
    boolean dfs(Map<Integer, ArrayList<Integer>> map, int[] visited, int i, int[] result) {
        if(visited[i] == -1) {
            return false;
        }
        if(visited[i] == 1) {
            return true;
        }
        
        visited[i] = -1;
        ArrayList<Integer> neighbors = map.get(i);
        if (neighbors != null) {
            for(int j : map.get(i)) {
            	if(!dfs(map,visited,j,result)) {
            		return false;
                }
            }
        }
        result[label--] = i;
        visited[i] = 1;
        return true;
    }
    
    public static void main(String[] args)  {
    	int[][] prerequisites = {{0,1}, {1,0}};
    	int[] res = new CourseScheduleII().findOrder(2, prerequisites);
    	 	
    	return;
    }
}

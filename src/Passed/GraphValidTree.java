package Passed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        if(hasCycle(-1,0,visited,adjList)) return false;
        
        for(int v : visited) {
            if(v==0) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int pred, int curr, int[] visited, List<List<Integer>> adjList) {
        visited[curr] = 1;
        for(Integer succ : adjList.get(curr)) {
        	
        	// important: exclude the case when succ = pred, as it is an undirected graph
            if (succ != pred) {
                if (visited[succ] == 1) {return true;}
                else if(visited[succ] == 0) {
                    if(hasCycle(curr, succ, visited, adjList)) {return true;}
                }
            }
        }
        visited[curr] = 2;
        return false;
    }
	
}

package Passed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) return res;
        
        if(n == 1 && edges.length == 0) {
            res.add(0);
            return res;
        }
        
        List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++) adjList.add(new HashSet<Integer>());
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
       for(int i = 0; i < n; i++) {
            if(adjList.get(i).size() == 1) leaves.add(i);
        }
        
        while(n > 2) {
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int leaf : leaves) {
                int neighbor = adjList.get(leaf).iterator().next(); 
                adjList.get(neighbor).remove(leaf);
                if(adjList.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

}

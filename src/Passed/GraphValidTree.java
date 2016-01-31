package Passed;

import java.util.HashSet;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for(int i=0; i<edges.length; i++) {
            if(!uf.union(edges[i][0], edges[i][1])) {
                return false;
            }
        }
        
        return uf.findCount() == 1;
    }
    
   int checkInput(int n, int[][] edges) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<edges.length; i++) {
            set.add(edges[i][0]);
            set.add(edges[i][1]);
        }
        
        return set.size();
    }
    
    public class UnionFind {
        int[] ids;
        int count;
        
        public UnionFind(int n) {
            ids = new int[n];
            for(int i = 0; i < n; i++) {
                ids[i] = i;
            }
            
            count = n;
        }
        
        public boolean union(int id1, int id2) {
            if(ids[id1] != ids[id2]) {
                for(int i = 0; i < ids.length; i++) {
                    if(ids[i] == ids[id1]) ids[i] = ids[id2];
                }
                count--;
                return true;
            } else {
                return false;
            }
        } 
        
        public int findCount() {
            return count;
        }
    }
    
    public static void main(String[] args) {
    	GraphValidTree gvt = new GraphValidTree();
    	int n = 5;
    	int[][] edges = {{0,1},{0,4},{1,4},{2,3}};
    	boolean result = gvt.validTree(n, edges);
    	System.out.println(result);
    }
}

package Passed;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
	 public int shortestDistance(int[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
	        int m = grid.length;
	        int n = grid[0].length;
	        
	        int[][] dist = new int[m][n];
	        int totBuilding = 0;
	        int[][] reach = new int[m][n];
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if(grid[i][j] == 1) {
	                    totBuilding++;
	                    bfs(grid, dist, reach, i, j, m, n);
	                }
	            }
	        }
	        
	        int min = Integer.MAX_VALUE;
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if (grid[i][j] == 0 && reach[i][j] == totBuilding) {
	                    min = Math.min(min, dist[i][j]);
	                }
	            }
	        }
	        if(min == Integer.MAX_VALUE) min = -1;
	        return min;
	    }
	    
	    private void bfs(int[][] grid, int[][] dist, int[][] reach, int i, int j, int m, int n) {
	        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	        Queue<int[]> queue = new LinkedList<int[]>();
	        queue.offer(new int[]{i,j});
	        boolean[][] visited = new boolean[m][n];
	        visited[i][j] = true;
	        int step = 1;
	        
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            for(int a = 0; a < size; a++) {
	                int[] cur = queue.poll();
	                for(int[] dir : dirs) { 
	                    int x = cur[0] + dir[0];
	                    int y = cur[1] + dir[1];
	                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
	                        reach[x][y]++;
	                        visited[x][y] = true;
	                        queue.offer(new int[] {x,y});
	                        dist[x][y] += step;
	                    }
	                }
	            }
	            
	            step++;
	        }
	    }

}

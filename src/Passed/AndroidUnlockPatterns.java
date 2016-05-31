package Passed;

public class AndroidUnlockPatterns {
	  private static int[][] dirs1 = new int[][] {
	        {1,0}, {-1,0}, {0,1}, {0,-1},
	        {1,1}, {-1,1}, {1,-1},{-1,-1},
	        {2,1}, {-2,1}, {2,-1},{-2,-1},
	        {1,2}, {-1,2}, {1,-2},{-1,-2}
	    };
	    
	    private static int[][] dirs2 = new int[][] {
	        {2,0}, {-2,0}, {0,2}, {0,-2}
	    };
	    
	    private static int[][] dirs3 = new int[][] {
	        {2,2}, {-2,2}, {2,-2}, {-2,-2}
	    };
	    
	    private int count = 0;
	    public int numberOfPatterns(int m, int n) {
	        boolean[][] visited = new boolean[3][3];
	        for(int i = 0; i < 3; i++) {
	            for(int j = 0; j <3; j++) {
	                visited[i][j] = true;
	                dfs(m,n,1,visited,i,j);
	                visited[i][j] = false;
	            }
	        }
	        return count;
	    }
	    
	    private void dfs(int m, int n, int level, boolean[][] visited, int i, int j) {
	        if (level >= m && level <= n) {
	            ++count;
	            if (level >= n) return;
	        }
	        
	        for(int[] dir : dirs1) {
	            int x = dir[0] + i;
	            int y = dir[1] + j;
	            
	            if(x>=0 && x<3 && y>=0 && y<3 && !visited[x][y]) {
	                visited[x][y] = true;
	                dfs(m,n,level+1,visited,x,y);
	                visited[x][y] = false;
	            }
	        }
	        
	        for(int[] dir : dirs2) {
	            int x = dir[0] + i;
	            int y = dir[1] + j;
	            
	            if(x>=0 && x<3 && y>=0 && y<3 && !visited[x][y] && visited[i+dir[0]/2][j+dir[1]/2]) {
	                visited[x][y] = true;
	                dfs(m,n,level+1,visited,x,y);
	                visited[x][y] = false;
	            }
	        }
	        
	        for(int[] dir : dirs3) {
	            int x = dir[0] + i;
	            int y = dir[1] + j;
	            
	            if(x>=0 && x<3 && y>=0 && y<3 && !visited[x][y] && visited[1][1]) {
	                visited[x][y] = true;
	                dfs(m,n,level+1,visited,x,y);
	                visited[x][y] = false;
	            }
	        }
	    }

}

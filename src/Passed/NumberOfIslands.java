package Passed;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        int res = 0;
        if(grid.length==0) return res;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1'){
                    searchIsland(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void searchIsland(char[][] grid, int i, int j){
    	 if(grid[i][j] != '1') return;
         
         grid[i][j]='0';
         if(i>0) searchIsland(grid, i-1, j);
         if(j>0) searchIsland(grid, i, j-1);
         if(i<grid.length-1) searchIsland(grid, i+1, j);
         if(j<grid[0].length-1) searchIsland(grid, i, j+1);
    }
}

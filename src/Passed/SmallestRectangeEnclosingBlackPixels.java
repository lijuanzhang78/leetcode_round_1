package Passed;

public class SmallestRectangeEnclosingBlackPixels {
	public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) return 0;
        int rows = image.length;
        int cols = image[0].length;
        
//      pay attention to the initial value here!
        int[] res = new int[4];
        res[0] = rows - 1;
        res[1] = 0;
        res[2] = cols - 1;
        res[3] = 0;
        
        dfs(image,x,y,rows,cols,res);
        return (res[1]-res[0]+1) * (res[3]-res[2]+1);
    }
    
    void dfs(char[][] image, int x, int y, int rows, int cols, int[] res) {
        image[x][y] = '0';
        
        if (x < res[0]) res[0] = x; 
        if (x > res[1]) res[1] = x; 
        if (y < res[2]) res[2] = y; 
        if (y > res[3]) res[3] = y;
        
        if(x+1 < rows && image[x+1][y] != '0') dfs(image,x+1,y,rows,cols,res);
        if(x-1 >= 0   && image[x-1][y] != '0') dfs(image,x-1,y,rows,cols,res);
        if(y+1 < cols && image[x][y+1] != '0') dfs(image,x,y+1,rows,cols,res);
        if(y-1 >= 0    && image[x][y-1] != '0') dfs(image,x,y-1,rows,cols,res);
    }
}

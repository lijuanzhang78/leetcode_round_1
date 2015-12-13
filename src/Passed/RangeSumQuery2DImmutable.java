package Passed;

public class RangeSumQuery2DImmutable {
	public class NumMatrix {
	    
	    int[][] sums;
	    public NumMatrix(int[][] matrix) {
	        if (matrix == null || matrix.length == 0) return;
	        
	        int n = matrix.length;
	        int m = matrix[0].length;
	        sums = new int[n+1][m+1];
	        
	        for(int i=1; i<=n; i++) {
	            for(int j=1; j<=m; j++) {
	                sums[i][j] = matrix[i-1][j-1] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
	            }
	        }
	    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        return sums[row2+1][col2+1] + sums[row1][col1] - sums[row1][col2+1] - sums[row2+1][col1];
	    }
	}
}

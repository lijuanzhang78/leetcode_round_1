package Passed;

public class MaximumSquare {
	 public int maximalSquare(char[][] matrix) {
	        if (matrix == null || matrix.length == 0) {
	            return 0;
	        }
	        
	        int m = matrix.length, n = matrix[0].length;
	        int[][] dp = new int[m][n];
	        int max = 0;
	        
	        for(int i = 0; i < m; i++) {
	            for(int j = 0; j < n; j++) {
	                if(i == 0) {
	                    dp[0][j] = matrix[0][j] - '0';
	                    max = Math.max(max, dp[0][j]);
	                }
	                else if (j == 0) {
	                    dp[i][0] = matrix[i][0] - '0';
	                    max = Math.max(max, dp[i][0]);
	                }
	                else {
	                    if (matrix[i][j] == '1') {
	                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
	                        max = Math.max(max, dp[i][j]);
	                    }
	                }
	            }
	        }
	        
	        return max * max;
	    }

}

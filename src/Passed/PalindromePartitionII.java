package Passed;

public class PalindromePartitionII {
	 public int minCut(String s) {
	        int len = s.length();
	        int[] dp = new int[len + 1];
	        boolean[][] p = new boolean[len+1][len+1];
	        
	        for(int i = 1; i <= len; i++) {
	            dp[i] = i;
	            for(int j = 1; j <= i; j++) {
	                if (s.charAt(i-1) == s.charAt(j-1)) {
	                    if (i - j < 2 || p[j+1][i-1]) {
	                        p[j][i] = true;
	                        if (j == 1) dp[i] = 0;
	                        else 
	                            dp[i] = Math.min(dp[i], dp[j-1]+1);
	                    }
	                }
	            }
	        }
	        return dp[len];
	    }
}

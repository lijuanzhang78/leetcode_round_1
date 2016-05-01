package Passed;

public class LongestValidParentheses {
	  public int longestValidParentheses(String s) {
	        int maxLen = 0;
	        int len = s.length();
	        int[] dp = new int[len + 1];
	        
	        dp[0] = 0;
	        for(int i = 1; i <= len; i++) {
	            if (s.charAt(i-1) == '(') {
	                dp[i] = 0;
	            } else {
	                int j = i - dp[i-1] - 2;
	                if (j >= 0 && s.charAt(j) == '(') {
	                    dp[i] = dp[i-1] + 2 + dp[j];
	                    maxLen = Math.max(maxLen, dp[i]);
	                }
	            }
	        }
	        
	        return maxLen;
	    }
}

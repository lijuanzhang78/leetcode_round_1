package Passed;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        
        int[][] dp = new int[tl+1][sl+1];
        
        for(int i = 0; i <= sl; i++) {
            dp[0][i] = 1;
        }
        
        for(int it = 1; it <= tl; it++) {
            for(int is = 1; is <= sl; is++) {
                if(s.charAt(is-1) == t.charAt(it-1)) {
                    dp[it][is] = dp[it-1][is-1] + dp[it][is-1];
                } else {
                    dp[it][is] = dp[it][is-1];
                }
            }
        }
        return dp[tl][sl];
    }
}

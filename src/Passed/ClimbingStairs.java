package Passed;

public class ClimbingStairs {
	public int climbStairs(int n) {
        int[] dp = new int[n];
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        dp[0] = 1;
        if(n >= 2) {
            dp[1] = 2;
            if(n == 2) return dp[1];
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n-1];
    }
}

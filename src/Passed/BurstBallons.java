package Passed;

public class BurstBallons {
	public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[] inums = new int[nums.length + 2];
        for(int i = 1; i <= nums.length; i++) {
            inums[i] = nums[i-1];
        }
        inums[0] = inums[nums.length + 1] = 1;
        
        int n = nums.length;
        
        int[][] dp = new int[n+2][n+2];
        for (int k = 1; k <= n; k++) {
            for(int i = 1; i <= n-k+1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], inums[x]*inums[i-1]*inums[j+1] + dp[i][x-1] + dp[x+1][j]);
                }
            }
        }

        return dp[1][n];
    }

}

package Passed;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        
        int[] dp = new int[amount+1];
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i + coins[j] <= amount) {
                	if(dp[i] < Integer.MAX_VALUE) {
                       dp[i + coins[j]] = Math.min(dp[i+coins[j]], dp[i] + 1);
                	}
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }

	public static void main(String[] args) {
		int[] coins = {2};
		int amount = 3;
		int res = new CoinChange().coinChange(coins, amount);
		
		
	}
}

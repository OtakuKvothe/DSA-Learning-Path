//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0)
            return 0;
        int[] dp = new int[amount + 1];
        // return helper(coins, amount, dp);

        // bottom-up approach
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int rem = i - coin;
                if (rem >= 0) {
                    int res = dp[rem];
                    if (res >= 0 && res < min) {
                        min = res + 1;
                    }
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return dp[amount];
    }

    // for top-down approach
    public int helper(int[] coins, int rem, int[] dp) {
        // System.out.println(rem);
        if (rem == 0)
            return 0;
        if (rem < 0)
            return -1;
        if (dp[rem - 1] != 0)
            return dp[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, dp);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        dp[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[rem - 1];
    }
}

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
public class BTTBAST4 {
    public int maxProfit(int k, int[] p) {
        int n = p.length;
        if (p.length == 0 || k == 0)
            return 0;

        int[][][] dp = new int[n + 1][k + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int t = 1; t <= k; t++) {
                dp[i][t][1] = Math.max(dp[i + 1][t][1], p[i] + dp[i + 1][t - 1][0]);
                dp[i][t][0] = Math.max(dp[i + 1][t][0], -p[i] + dp[i + 1][t][1]);
            }
        }
        return dp[0][k][0];
    }
}

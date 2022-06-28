//https://leetcode.com/problems/minimum-cost-for-tickets/

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        int p = 0;
        for(int i=1; i<dp.length && p < days.length; i++) {
            if(i == days[p]) {
                p++;
                int d1 = dp[i-1] + costs[0], d7 = dp[Math.max(i-7, 0)] + costs[1], d30 = dp[Math.max(i-30, 0)] + costs[2];
                dp[i] = Math.min(d1, Math.min(d7, d30));
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[days[days.length-1]];
    }
}

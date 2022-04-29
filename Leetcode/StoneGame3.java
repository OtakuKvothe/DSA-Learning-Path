//https://leetcode.com/problems/stone-game-iii

public class StoneGame3 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1; i>=0; i--) 
        {
            int take = 0;
            dp[i] = Integer.MIN_VALUE;
            for(int k=i; k<Math.min(n, i+3); k++) {
                take += stoneValue[k];
                dp[i] = Math.max(dp[i], take - dp[k+1]);
            }
        }
        if(dp[0] > 0) return "Alice";
        else if(dp[0] < 0) return "Bob";
        else return "Tie";
    }
}

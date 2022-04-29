//https://leetcode.com/problems/dungeon-game/

public class DungeonGame {
    public int calculateMinimumHP(int[][] d) {
        int n = d.length, m = d[0].length;
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++) {
            dp[i][m] = Integer.MAX_VALUE;
        }
        for(int i=0; i<=m; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }
        
        dp[n][m-1] = 1;
        dp[n-1][m] = 1;

        
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - d[i][j];
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }
        
        return dp[0][0];
    }
}

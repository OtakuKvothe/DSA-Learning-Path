//https://leetcode.com/problems/cherry-pickup-ii/
public class CherryPickup2 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        return calc(grid, dp, m, n, 0, 0, n-1);
    }
    
    public int calc(int[][] grid, Integer[][][] dp, int m, int n, int r, int c1, int c2){
        if(r == m) return 0;
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
        int ans = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int nc1 = c1 + i, nc2 = c2 + j;
                if(nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n){
                    ans = Math.max(ans, calc(grid, dp, m, n, r + 1, nc1, nc2));
                }
            }
        }
        int c = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        dp[r][c1][c2] = c + ans;
        return c + ans;
    }
}

/**
 * Idea

Let dp(r, c1, c2) is the maximum cherries we can collect in grid from row=r to bottom row, where c1 is the column position of robot1, c2 is the column position of robot2.

At each step, we move both robot1 and robot2 to next row, and with all possibles columns (c-1, c, c+1).

Please keep in mind that if 2 robots go into the same cell, we only collect cherries once.
 */
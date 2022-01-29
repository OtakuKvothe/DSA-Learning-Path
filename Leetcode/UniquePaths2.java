//https://leetcode.com/problems/unique-paths-ii
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int dp[][] = new int[grid.length+1][grid[0].length+1];
        dp[1][1]=(grid[0][0]==1)?0:1;
        for(int i=1; i<=grid.length; i++){
            for(int j=1; j<=grid[0].length; j++){
                if(i==1&&j==1) continue;
                dp[i][j]=(grid[i-1][j-1]==1)?0:(dp[i-1][j]+dp[i][j-1]);
            }
        }
        return dp[grid.length][grid[0].length];
    }
}

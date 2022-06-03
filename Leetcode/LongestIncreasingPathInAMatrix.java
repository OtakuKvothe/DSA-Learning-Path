//https://leetcode.com/problems/longest-increasing-path-in-a-matrix

//DFS + DP

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        if(m == 1 && n == 1) {
            return 1;
        }
        
        int[][] dp = new int[m][n];              
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int res = 0;
                
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res = Math.max(res, dfs(mat, dp, dirs, i, j));
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] mat, int[][] dp, int[][] dirs, int i, int j) {
        int m = mat.length, n = mat[0].length;
        
        if(dp[i][j] > 0)
            return dp[i][j];
        
        int max = 0;
        for(int dir[]: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x>=0 && x<m && y>=0 && y<n && mat[x][y] > mat[i][j]) {
                max = Math.max(max, dfs(mat, dp, dirs, x, y));
            }
        }
        
        return dp[i][j] = max + 1;
    }
}

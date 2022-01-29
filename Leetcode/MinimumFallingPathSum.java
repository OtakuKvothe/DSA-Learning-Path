//https://leetcode.com/problems/minimum-falling-path-sum
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix[0].length; i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], Math.min((j-1>=0)?dp[i-1][j-1]:Integer.MAX_VALUE, (j+1<=matrix[0].length-1)?dp[i-1][j+1]:Integer.MAX_VALUE));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<matrix[0].length; i++){
            min=Math.min(min, dp[matrix.length-1][i]);
        }
        return min;
    }
}

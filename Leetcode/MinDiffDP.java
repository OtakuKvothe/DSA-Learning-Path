//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule
import java.util.Arrays;

public class MinDiffDP {
    public int minDifficulty(int[] jd, int d) {
        if(jd.length<d) return -1;
        int[][] dp = new int[jd.length][d+1];
        for(int[] row: dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[jd.length-1][d]=jd[jd.length-1];
        for(int i=jd.length-2; i>=0; i--){
            dp[i][d] = Math.max(jd[i], dp[i+1][d]);
        }
        for(int i=d-1; i>=1; i--){
            for(int j=i-1; j<jd.length-(d-i); j++){
                int hrd = 0;
                for(int k=j; k<jd.length-(d-i); k++){
                    hrd = Math.max(hrd, jd[k]);
                    dp[j][i]=Math.min(dp[j][i], dp[k+1][i+1]+hrd);
                }
            }
        }
        return dp[0][1];
    }
}

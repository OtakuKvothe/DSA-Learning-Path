//https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
public class MaxScore {
    public int maximumScore(int[] nums, int[] multipliers) {
        int dp[][] = new int[multipliers.length+1][multipliers.length+1];
        for(int i=multipliers.length-1; i>=0; i--){
            int m = multipliers[i];
            for(int j=i; j>=0; j--){
                int k = nums.length-1-(i-j);
                dp[i][j]=Math.max(m*nums[j]+dp[i+1][j+1], m*nums[k]+dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
}

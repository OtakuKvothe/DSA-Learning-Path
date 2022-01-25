//https://leetcode.com/problems/longest-increasing-subsequence/

//IMP: Try out the O(nlogn) approach
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

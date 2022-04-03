//https://leetcode.com/problems/minimum-size-subarray-sum
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, sum=0, res = Integer.MAX_VALUE;
        while(l<=r&&r<nums.length) {
                sum+=nums[r++];
            if(sum >= target) {
                while(sum >= target) {
                    res = Math.min(res, r-l);
                    sum -= nums[l++];
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

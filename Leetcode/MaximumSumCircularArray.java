//https://leetcode.com/problems/maximum-sum-circular-subarray/
public class MaximumSumCircularArray {
    public int maxSubarraySumCircular(int[] nums) {
        int curr=0, max=Integer.MIN_VALUE;
        int cur=0, min=Integer.MAX_VALUE, total=0;
        for(int i=0; i<nums.length; i++){
            curr = Math.max(curr+nums[i], nums[i]);
            max=Math.max(curr, max);
            cur=Math.min(cur+nums[i], nums[i]);
            min=Math.min(min, cur);
            total+=nums[i];
        }
        return max>0?(Math.max(max, total-min)):max;
    }
}

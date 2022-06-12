//https://leetcode.com/problems/maximum-erasure-value

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] pres = new boolean[10001];
        int l = 0, r = 0, sum = 0, res = 0;
        while(l <= r && r < nums.length) {
            if(pres[nums[r]]) {
                while(l <= r && pres[nums[r]]) {
                    pres[nums[l]] = false;
                    sum -= nums[l];
                    l++;
                }
            } else {
                pres[nums[r]] = true;
                sum += nums[r];
                res = Math.max(res, sum);
                r++;
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    public int helper(int[] nums, int i, int curr){
        if(i==nums.length) return curr;
        return helper(nums, i+1, curr^nums[i])+helper(nums, i+1, curr);
    }
}

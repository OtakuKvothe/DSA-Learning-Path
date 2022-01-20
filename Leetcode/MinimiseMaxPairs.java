//https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
import java.util.Arrays;

public class MinimiseMaxPairs {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for(int i=0; i<nums.length/2; i++){
            max=Math.max(max, nums[i]+nums[nums.length-i-1]);
        }
        return max;
    }
}

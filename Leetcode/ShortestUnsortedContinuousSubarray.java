//https://leetcode.com/problems/shortest-unsorted-continuous-subarray

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int i=-1, j=0, lMax = nums[0], rMin = nums[nums.length-1];       
        for(int t=0; t<nums.length; t++) {
            if(lMax > nums[t]) {
                i = t;
            } else lMax = nums[t];             
            if(rMin < nums[nums.length-1-t]) {
                j = nums.length-1-t;
            } else rMin = nums[nums.length-1-t];
        }
        return i-j+1;
    }
}

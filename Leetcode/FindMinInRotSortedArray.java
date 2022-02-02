//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
public class FindMinInRotSortedArray {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1, min = Integer.MAX_VALUE;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            
            min = Math.min(min, nums[mid]);
            
            if(nums[mid] >= nums[hi]){
                lo=mid+1;
            }else if(nums[mid] < nums[hi]){
                hi=mid-1;
            }
        }
        return min;
    }
}

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
public class FindMinInRotSortedArray2 {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1, min = Integer.MAX_VALUE;
        while(lo <= hi){
            min = Math.min(min, Math.min(nums[lo], nums[hi]));
            
            while(nums[lo] == nums[hi] && lo < hi){
                lo = (lo < nums.length-1)?lo+1:lo;
                hi = (hi > 0)?hi-1:hi;
            }
            
            min = Math.min(min, Math.min(nums[lo], nums[hi]));
            
            int mid = (lo+hi)/2;
            
            if(nums[mid] > nums[hi]){
                lo=mid+1;
            }else if(nums[mid] < nums[hi]){
                hi=mid;
            }else{
                hi--;
            }
        }
        return min;
    }
}

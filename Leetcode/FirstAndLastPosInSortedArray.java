//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPosInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int res[]=new int[2];
        res[0]=-1; res[1]=-1;
        if(nums.length == 0) return res;
        while(lo < hi){
            int mid = (lo+hi)/2;
            if(nums[mid] < target) lo = mid + 1;
            else hi=mid;
        }
        
        if(nums[lo] != target) return res;
        res[0] = lo;
        
        hi = nums.length - 1;
        
        while(lo < hi){
            int mid = (lo + hi)/2+1;
            if(nums[mid]>target) hi = mid-1;
            else lo=mid;
        }
        
        res[1]=hi;
        
        return res;
    } 
}

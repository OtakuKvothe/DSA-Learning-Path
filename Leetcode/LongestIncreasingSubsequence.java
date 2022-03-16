//https://leetcode.com/problems/longest-increasing-subsequence/

//IMP: Try out the O(nlogn) approach - DP + Binary Search
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1) return nums.length;
        //dp[i] represent the smallest possible last element in a strictly increasing subsequence with length i+1
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int len=0;
        for(int i=0; i<nums.length; i++) {
            int x = binarySearch(dp, len, nums[i]);
            dp[x]=nums[i];
            if(x == len) len++;
        }
        return len;
    }
    
    public int binarySearch(int[] arr, int high, int num){
        int low = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid]==num) return mid;
            else if(arr[mid] < num) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}

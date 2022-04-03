//https://leetcode.com/problems/split-array-largest-sum
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max=0, sum=0;
        for(int num: nums) {
            max = Math.max(num, max);
            sum += num;
        }
        int low = max, high = sum;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(canSplit(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public boolean canSplit(int[] nums, int target, int m) {
        int tmp = 0, n = 1;
        for(int num: nums) {
            tmp += num;
            if(tmp > target) {
                n++;
                tmp = num;
                if(n > m) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

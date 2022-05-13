//https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int m) {
        int min = 1, max = (int)1e9;
        while(min < max) {
            int mid = min + (max-min)/2, c = 0;
            for(int i: nums)
                c += (i-1)/mid;
            if(c > m) {
                min = mid+1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}

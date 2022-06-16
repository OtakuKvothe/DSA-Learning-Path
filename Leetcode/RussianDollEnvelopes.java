// https://leetcode.com/problems/russian-doll-envelopes

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e, (a, b) -> {
            //clever trick on this line
            return a[0] == b[0] ? b[1]-a[1] : a[0]-b[0];
        });
        int dp[] = new int[e.length];
        int res = 0;
        for(int[] env: e) {
            int x = binSearch(dp, res, env[1]);
            dp[x] = env[1];
            if(x == res) res++;
        }
        return res;
    }
    
    public int binSearch(int[] dp, int high, int num) {
        int low = 0;
        while(low < high) {
            int mid = low + (high - low)/2;
            if(dp[mid] == num)
                return mid;
            else if(dp[mid] < num)
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
}

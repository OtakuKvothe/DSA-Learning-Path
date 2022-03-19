//https://leetcode.com/problems/knight-dialer/
import java.util.Arrays;

public class KnightDialer {
    public int knightDialer(int n) {
        int mod = 1000000007;
        int[][] dirs = new int[][]{{4, 6}, {8, 6}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int dp[] = new int[10];
        Arrays.fill(dp, 1);
        for(int i=2; i<=n; i++){
            int dp2[] = new int[10];
            for(int j=0; j<=9; j++){
                int tmp = 0;
                for(int t: dirs[j]){
                    tmp=(tmp+dp[t])%mod;
                }
                dp2[j] = tmp;
            }
            dp=dp2;
        }
        int res=0;
        for(int i: dp){
            res=(res+i)%mod;
        }
        return res;
    }
}

//Try the log n approach
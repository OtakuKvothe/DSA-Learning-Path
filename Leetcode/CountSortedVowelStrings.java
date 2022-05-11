import java.util.Arrays;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        //return count(1, n);
        int dp[] = new int[5];
        Arrays.fill(dp, 1);
        for(int i=2; i<=n; i++) {
            for(int j=4; j>=0; j--) {
                int tmp = 0;
                for(int k=j; k>=0; k--) {
                    tmp += dp[k];
                }
                dp[j] = tmp;
            }
        }
        
        int res = 0;
        
        for(int i: dp)
            res += i;
        
        return res;

        //math soln
        // return (n+4)*(n+3)*(n+2)*(n+1)/24;
    }
    
    //without dp
    public int count(int curr, int rem) {
        if(rem < 0 || curr > 5)
            return 0;
        
        if(rem == 0)
            return 1;
        
        int res = 0;
        
        for(int i=curr; i<=5; i++) {
            res += count(i, rem-1);
        }
        
        return res;
    }
}

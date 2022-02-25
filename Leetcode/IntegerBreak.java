//https://leetcode.com/problems/integer-break/

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i/2; j++){
                dp[i] = Math.max(dp[i], Math.max(j*dp[i-j], j*(i-j)));
            }
        }
        return dp[n];
    }
}
/**
 * O(log n) soln
 *  public int integerBreak(int n) {
        if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        else if(n%3 == 0)
            return (int)Math.pow(3, n/3);
        else if(n%3 == 1)
            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
        else 
            return 2 * (int) Math.pow(3, n/3);
    }
 */

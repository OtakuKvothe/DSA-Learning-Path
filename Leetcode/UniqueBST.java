//https://leetcode.com/problems/unique-binary-search-trees
public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; //actually zero, but set 1 so it does not make the entire product zero
        dp[1] = 1;
        for(int i=2; i <= n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}

// https://leetcode.com/problems/ones-and-zeroes

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str: strs) {
            int n1 = 0, n0 = 0;
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '0') {
                    n0++;
                } else {
                    n1++;
                }
            }
            for(int i=m; i>=n0; i--) {
                for(int j=n; j>=n1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-n0][j-n1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

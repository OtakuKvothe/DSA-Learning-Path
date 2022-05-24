// https://leetcode.com/problems/palindromic-substrings

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s.length() == 1) 
            return 1;
        
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        int res = s.length();
        
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                res++;
            }
        }
        
        for(int l = 3; l<=n; l++) {
            for(int i=0; i<n-l+1; i++) {
                int j = i+l-1;
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        
        return res;
    }
}

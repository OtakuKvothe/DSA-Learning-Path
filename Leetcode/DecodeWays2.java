//https://leetcode.com/problems/decode-ways-ii

import java.util.Arrays;

public class DecodeWays2 {
    public int numDecodings(String s) {
        long[] dp = new long[s.length()];
        Arrays.fill(dp, -1);
        return (int)parts(dp, s, 0);
    }
    
    public long parts(long[] dp, String s, int start) {
        
        if(start == s.length()) {
            return 1;
        }
        
        if(dp[start] > -1) 
            return dp[start];
        
        if(s.charAt(start) == '0')
            return dp[start] = 0;
        
        long res = 0;
        int mod = 1000000007;;
        
        char c = s.charAt(start);
        if(c == '*') {
            res = (res + 9 * parts(dp, s, start+1))%mod;
            if(start < s.length()-1) res = (res + resolveNum(s.substring(start, start+2)) * parts(dp, s, start+2))%mod;
        } else {
            res = (res + parts(dp, s, start+1))%mod;
            if(start < s.length()-1) res = (res + resolveNum(s.substring(start, start+2)) * parts(dp, s, start+2))%mod;
        }
        
        return dp[start] = res%mod;
    }
    
    public int resolveNum(String s) {
        char c1 = s.charAt(0), c2 = s.charAt(1);        

        if (c1 == '*' && c2 == '*') {
            return 15;
        } else if (c1 == '*') {
            if(c2 <= '6') {
                return 2;
            } else return 1;
        } else if (c2 == '*') {
            if(c1 >= '3') {
                return 0;
            } else if(c1 == '2') {
                return 6;
            } else if(c1 == '1') {
                return 9;
            }
        } else if(c1 == '1' || (c1 == '2' && c2 <= '6')) return 1;
        
        return 0;
    }
}

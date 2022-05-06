//https://leetcode.com/problems/decode-ways-ii

import java.util.Arrays;

public class DecodeWays2 {
    public int numDecodings(String s) {
        long[] dp = new long[s.length()];

        //Top-down approach
        //Arrays.fill(dp, -1);
        //return (int)parts(dp, s, 0);
        
        int mod = (int) 1e9 + 7;
        
        char a = s.charAt(0);
        if(a == '0') {
            return 0;
        } else if(a == '*') {
            dp[0] = 9;
        } else {
            dp[0] = 1;
        }
        
        for(int i=1; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(c == '*') {
                dp[i] = ((9 * dp[i-1])%mod 
                         + 
                         ((s.charAt(i-1) == '0') ? 
                            0 :
                            (resolveNum(s.charAt(i-1), s.charAt(i)) * ((i-2<0)?1:dp[i-2])))%mod)%mod;
            } else {
                if(c != '0') 
                    dp[i] = (dp[i-1])%mod;  
                
                if(s.charAt(i-1) != '0') 
                    dp[i] = (dp[i]
                             + 
                             resolveNum(s.charAt(i-1), s.charAt(i)) * ((i-2<0)?1:dp[i-2]))%mod;
            }
        }
        
        return (int)dp[s.length()-1];
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
            
            if(start < s.length()-1) 
                res = (res + resolveNum(s.charAt(start), s.charAt(start+1)) * parts(dp, s, start+2))%mod;
        } else {
            res = (res + parts(dp, s, start+1))%mod;
            
            if(start < s.length()-1) 
                res = (res + resolveNum(s.charAt(start), s.charAt(start+1)) * parts(dp, s, start+2))%mod;
        }
        
        return dp[start] = res%mod;
    }
    
    public int resolveNum(char c1, char c2) {
        //char c1 = s.charAt(0), c2 = s.charAt(1);        

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

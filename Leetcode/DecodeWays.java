import java.util.Arrays;

//https://leetcode.com/problems/decode-ways

public class DecodeWays {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()];
        dp[0]=1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }
            if(Integer.parseInt(s.substring(i-1, i+1))<=26&&s.charAt(i-1)!='0'){
                dp[i]+=(i-2>=0)?dp[i-2]:1;
            }
        }
        return dp[s.length()-1];
    }

    //MARK :- Recursive approach top-down

    public int numDecodingsRecursive(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(dp, s, 0);
    }
    
    public int decode(int[] dp, String s, int index) {
        if(index == s.length()) {
            return 1;
        }
        
        if(dp[index] != -1) {
            return dp[index];
        }
        
        if(s.charAt(index) == '0') {
            return dp[index] = 0;
        }
        
        dp[index] = decode(dp, s, index+1);
        if(index < s.length()-1 && validateNum(s.substring(index, index+2))) {
            dp[index] += decode(dp, s, index+2);
        }
        
        return dp[index];
    }
    
    public boolean validateNum(String s) {
        int num = Integer.parseInt(s);
        return (num >= 10 && num <= 26);
    }
}

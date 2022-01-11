//https://leetcode.com/problems/restore-ip-addresses

/**
 * Do not refer this as optimal, it's a very expensive solution with poor planning, even though it is a good implementation of backtracking concept.
 */

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(res, s, 0, 3);
        return res;
    }
    
    public void helper(List<String> res, String s, int index, int rem){
        if(rem<=0){
            if(verify(s)) res.add(s);
            return;
        }
        if(index<0||index>=s.length()) return;
        for(int i=index; i<Math.min(s.length()-rem, index+3); i++){
            helper(res, s.substring(0, i+1)+"."+s.substring(i+1), i+2, rem-1);
        }
    }
    
    public boolean verify(String s){
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='.'){
                if(s.charAt(i)=='0'){
                    if(i==0&&s.charAt(i+1)!='.') return false;
                    else if(i>0&&i<s.length()-1&&s.charAt(i-1)=='.'&&s.charAt(i+1)!='.') return false;
                }
                sum=sum*10+(int)(s.charAt(i)-'0');
            }else{
                if(sum<0||sum>255) return false;
                sum=0;
            }
        }
        if(sum<0||sum>255) return false;
        return true;
    }
}

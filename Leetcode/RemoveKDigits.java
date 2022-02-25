//https://leetcode.com/problems/remove-k-digits
import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int l = num.length();
        if(k==l) return "0";
        
        Stack<Character> st = new Stack<>();
        for(int i=0; i<l; i++){
            while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int i=0;
        while(sb.length()>1 && sb.charAt(i)=='0'){
            sb.deleteCharAt(i);
        }
        
        return sb.toString();
    }
}

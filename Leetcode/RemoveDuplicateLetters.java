//https://leetcode.com/problems/remove-duplicate-letters
import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length()<=1) return s;
        boolean[] pres = new boolean[26];
        int[] last = new int[26];
        StringBuilder res = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){          
            last[s.charAt(i)-'a']=i;
        }
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(pres[ch]) continue;
            while(!st.isEmpty()&&ch<st.peek()&&i<last[st.peek()]){
                pres[st.pop()]=false;
            }
            st.push(ch);
            pres[ch]=true;
        }
        while(!st.isEmpty()){
            res.append((char)(st.pop()+'a'));
        }
        return res.reverse().toString();
    }
}

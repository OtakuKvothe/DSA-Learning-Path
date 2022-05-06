// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii
import java.util.Stack;

public class RemoveAllAdjacentDuplicateLettersInAString2 {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && c == s.charAt(st.peek()[0])) {
                st.peek()[1]++;
            } else {
                st.push(new int[]{i, 1});
            }
            if(st.peek()[1] == k)
                st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            int[] h = st.pop();
            while(h[1]-->0) {
                sb.append(s.charAt(h[0]));
            }
        }
        return sb.reverse().toString();
    }
}
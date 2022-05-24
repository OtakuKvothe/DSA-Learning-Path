import java.util.Stack;

public class LongestValidParenthesis {

    //no extra space
    public int longestValidParenthesesNoExtraSpace(String s) {
        int n = s.length(), l = 0, r = 0, max = 0;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '(')
                l++;
            else 
                r++;
            
            if(l == r) {
                max = Math.max(max, 2*r);
            } else if(r > l) {
                l=0;
                r=0;
            }
        }
        l=0;
        r=0;
        for(int i=n-1; i>=0; i--) {
            char c = s.charAt(i);
            if(c == '(') 
                l++;
            else 
                r++;
            
            if(l == r) {
                max = Math.max(max, 2*l);
            } else if(l > r) {
                l=0;
                r=0;
            }
        }
        
        return max;
    }

    //using stack
    public int longestValidParenthesesUsingStack(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(i);
            } else {
                st.pop();
                if(!st.isEmpty()) {                    
                    res = Math.max(res, i-st.peek());
                } else {
                    st.push(i);
                }
            }
        }
        return res;
    }

    //using DP
    public int longestValidParenthesesUsingDP(String s) {
        int n = s.length(), max = 0;
        int[] dp = new int[n];
        for(int i=1; i<n; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = ((i-1>0) ? dp[i-2] : 0) + 2; 
                } else if(i-dp[i-1] > 0 && s.charAt(i-1-dp[i-1]) == '(') {
                    dp[i] = dp[i-1] + ((i-2-dp[i-1] >= 0) ? dp[i-2 - dp[i-1]] : 0) + 2;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}

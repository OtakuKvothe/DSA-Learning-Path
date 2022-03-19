//https://leetcode.com/problems/score-of-parentheses
public class ScoreOfParenthesis {
    public int scoreOfParentheses(String s) {
        int res = 0, l=0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                l++;
            }else {
                l--;
            }
            if(i>0&&ch == ')'&&s.charAt(i-1) == '(') res+=1<<l;
        }
        return res;
    }
}

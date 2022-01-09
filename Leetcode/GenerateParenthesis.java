//https://leetcode.com/problems/generate-parentheses/
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper("", n, n, res);
        return res;
    }
    
    public void helper(String s, int o, int c, List<String> res){
        if(o<0 || c<0 || o>c) return;
        if(o>0) helper(s.concat("("), o-1, c, res);
        if(c>0) helper(s.concat(")"), o, c-1, res);
        if(o==0&&c==0) res.add(s);
    }
}

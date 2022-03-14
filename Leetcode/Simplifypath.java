
//https://leetcode.com/problems/simplify-path
import java.util.Stack;

public class Simplifypath {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        for (String tmp : path.split("/")) {
            if (tmp.equals("..")) {
                if (!stk.isEmpty())
                    stk.pop();
            } else if (!tmp.equals(".") && !tmp.equals(""))
                stk.push(tmp);
        }

        StringBuffer res = new StringBuffer();
        while (!stk.isEmpty()) {
            res.insert(0, "/" + stk.pop());
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}

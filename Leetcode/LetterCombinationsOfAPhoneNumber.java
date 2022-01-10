//https://leetcode.com/problems/letter-combinations-of-a-phone-number
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        char[][] c = {{'a', 'b', 'c'},
                      {'d', 'e', 'f'},
                      {'g', 'h', 'i'},
                      {'j', 'k', 'l'},
                      {'m', 'n', 'o'},
                      {'p', 'q', 'r', 's'},
                      {'t', 'u', 'v'},
                      {'w', 'x', 'y', 'z'}};        
        List<String> res = new LinkedList<>();
        helper(c, "", digits, 0, res);
        return res;
    }
    
    public void helper(char[][] c, String s, String d, int i, List<String> res){
        if(i>=d.length()){
            if(s.length()>0) res.add(s);
            return;
        }
        int x = (int)(d.charAt(i)-'0');
        
        for(char ch: c[x-2]){
            helper(c, s+ch, d, i+1, res);
        }
    }
}

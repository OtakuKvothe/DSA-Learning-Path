//https://leetcode.com/problems/palindrome-partitioning/submissions/
import java.util.LinkedList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] v=new boolean[n][n];        
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i)==s.charAt(j)&&(i==n-1||j-i<=1||v[i+1][j-1])) v[i][j]=true;
            }
        }
        List<List<String>> res = new LinkedList<>();
        List<String> t = new LinkedList<>();
        bt(s, 0, t, res, v);
        return res;
    }
    
    public void bt(String s, int index, List<String> t, List<List<String>> res, boolean[][] v){
        if(index==s.length()){
            res.add(new LinkedList<>(t));
            return;
        }
        for(int i=index; i<s.length(); i++){
            if(v[index][i]){
                t.add(s.substring(index, i+1));
                bt(s, i+1, t, res, v);
                t.remove(t.size()-1);
            }
        }
    }
}

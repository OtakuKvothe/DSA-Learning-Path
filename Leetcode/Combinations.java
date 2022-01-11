//https://leetcode.com/problems/combinations/
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), 1, k, n);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int curr, int rem, int n){
        if(curr>n||rem==0){
            if(rem==0) res.add(new LinkedList<>(list));
            return;
        }
        for(int i=curr; i<=n-rem+1; i++){
            list.add(i);
            helper(res, list, i+1, rem-1, n);
            list.remove(list.size()-1);
        }
    }
}

//https://leetcode.com/problems/combination-sum/
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(res, list, 0, candidates, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int s, int[] c, int t){
        if(t==0){
            res.add(new LinkedList<>(list));
        }
        if(t<0){
            return;
        }
        for(int i = s; i<c.length; i++){
            list.add(c[i]);
            helper(res, list, i, c, t-c[i]);
            list.remove(list.size()-1);
        }
    }
}

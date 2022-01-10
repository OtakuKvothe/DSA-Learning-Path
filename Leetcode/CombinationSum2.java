//https://leetcode.com/problems/combination-sum-ii
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        helper(res, new LinkedList<>(), 0, candidates, target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int s, int[] c, int t){
        if(t==0){
            res.add(new LinkedList<>(list));
        }
        else if(t<0){
            return;
        }
        for(int i = s; i<c.length; i++){
            if(i>s && c[i]==c[i-1]) continue;
            list.add(c[i]);
            helper(res, list, i+1, c, t-c[i]);
            list.remove(list.size()-1);
        }
    }
}

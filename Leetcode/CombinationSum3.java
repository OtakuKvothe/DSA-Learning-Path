//https://leetcode.com/problems/combination-sum-iii

import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), n, 0, k, 1);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int target, int sum, int rem, int start){
        if(rem == 0){
            if(sum > target) return;
            else if(sum == target){
                res.add(new LinkedList<>(list));
                return;
            }
        }
        for(int i=start; i<=9; i++){
            list.add(i);
            helper(res, list, target, sum+i, rem-1, i+1);
            list.remove(list.size()-1);
        }
    }
}

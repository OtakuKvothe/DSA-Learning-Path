//https://leetcode.com/problems/combination-sum/
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int t) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, 0, t);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int ind, int t){
        int f = list.size();
        for(int i=ind; i<nums.length; i++){
            if(t-nums[i]<0) continue;
            list.add(nums[i]);
            if(t-nums[i]==0){
                res.add(new ArrayList<>(list));
            }else{
                helper(res, list, nums, i, t-nums[i]);
            }
            list.remove(f);
        }
    }
}

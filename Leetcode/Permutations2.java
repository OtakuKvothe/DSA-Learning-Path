//https://leetcode.com/problems/permutations-ii
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(res, new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] u){
        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
        }
        
        for(int k=0; k<nums.length; k++){
            if(u[k] || k>0 && nums[k]==nums[k-1]&&!u[k-1]) continue;
            list.add(nums[k]);
            u[k]=true;
            dfs(res, list, nums, u);
            list.remove(list.size()-1);
            u[k] = false;
        }
    }
}

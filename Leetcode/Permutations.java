//https://leetcode.com/problems/permutations
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<Integer>(), nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
        }
        
        for(int i: nums){
            if(list.contains(i)) continue;
            list.add(i);
            dfs(res, list, nums);
            list.remove(list.size()-1);
        }
    }
}

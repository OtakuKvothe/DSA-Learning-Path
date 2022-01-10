//https://leetcode.com/problems/subsets-ii/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(res, new LinkedList<>(), 0, nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int i, int[] nums){
        res.add(new LinkedList<>(list));
        for(int k=i; k<nums.length; k++){
            if(k>i && nums[k]==nums[k-1]) continue;
            list.add(nums[k]);
            dfs(res, list, k+1, nums);
            list.remove(list.size()-1);
        }
    }
}

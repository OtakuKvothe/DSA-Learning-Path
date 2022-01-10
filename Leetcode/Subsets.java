//https://leetcode.com/problems/subsets/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(res, new LinkedList<>(), 0, nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int i, int[] nums){
        res.add(new LinkedList<>(list));
        while(i<nums.length){
            list.add(nums[i]);
            dfs(res, list, i+1, nums);
            list.remove(list.size()-1);
            i++;
        }
    }
}

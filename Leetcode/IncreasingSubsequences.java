//https://leetcode.com/problems/increasing-subsequences
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(res, new ArrayList<>(), 0, nums);
        return new ArrayList<>(res);
    }
    
    public void helper(Set<List<Integer>> res, List<Integer> list, int index, int[] nums){
        if(index > nums.length) return;
        if(list.size() > 1){
            if(!res.contains(list)) res.add(new ArrayList<>(list));
        }
        for(int i = index; i<nums.length; i++){
            if(list.size()==0||nums[i]>=list.get(list.size()-1)){
                list.add(nums[i]);
                helper(res, list, i+1, nums);
                list.remove(list.size()-1);
            }
        }
    }
}

//https://leetcode.com/problems/3sum
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(nums[i] > 0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left = i+1, right = nums.length - 1, t=-nums[i];
            while(left < right){
                if(nums[left]+nums[right]==t){
                    List<Integer> l = List.of(nums[i], nums[left], nums[right]);
                    res.add(l);
                    left++;
                    right--;
                    while(left < right && nums[left]==nums[left-1]) left++;
                    while(left < right && nums[right]==nums[right+1]) right--;
                }else if(nums[right]+nums[left]>t){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}

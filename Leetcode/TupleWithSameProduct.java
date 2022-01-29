//https://leetcode.com/problems/tuple-with-same-product
import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                res += 8*map.getOrDefault(nums[i]*nums[j], 0);
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j], 0)+1);
            }
        }
        return res;
    }
}

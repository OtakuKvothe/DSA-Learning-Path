import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int res = 0;
        for(int key: map.keySet()){
            if((k==0&&map.get(key)>=2)||(k>0&&map.containsKey(key+k))){
                res++;
            }
        }
        return res;
    }
}

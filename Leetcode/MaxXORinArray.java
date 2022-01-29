//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array
import java.util.HashSet;
import java.util.Set;

public class MaxXORinArray {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for(int i=31; i>=0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num: nums){
                set.add(mask & num);
            }
            
            //maximum possible value of xor till 2^i th digit: previous maximum and another 1 appended to the 2^i th digit
            int tryxor = max | (1 << i);
            
            for(int num: set){
                if(set.contains(tryxor ^ num)){
                    max = tryxor;
                    break;
                }
            }
        }
        return max;
    }
}

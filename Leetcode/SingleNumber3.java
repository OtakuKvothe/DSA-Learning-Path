//https://leetcode.com/problems/single-number-iii
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i: nums){
            xor ^= i;
        }
        int t = xor;
        xor &= -xor;
        int[] res = new int[2];
        for(int num: nums){
            if((num & xor) == 0){
                res[0] ^= num;
            }
        }
        res[1] = t ^ res[0];
        return res;
    }
}

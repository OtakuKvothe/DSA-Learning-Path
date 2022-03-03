//https://leetcode.com/problems/arithmetic-slices
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int n=2, res=0;
        for(int i=2; i<nums.length; i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                n=n+1;
            }else{
                n=2;
            }
            if(n>=3) res+=n-2;
        }
        return res;
    }
}

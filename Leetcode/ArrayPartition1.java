//https://leetcode.com/problems/array-partition-i
public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        int[] b = new int[20001];
        for(int i=0; i<nums.length; i++){
            b[nums[i]+10000]++;
        }
        int sum=0;
        boolean odd=true;
        for(int i=0; i<20001; i++){
            while(b[i]>0){
                if(odd){
                    sum+=i-10000;
                }
                odd=!odd;
                b[i]--;
            }
        }
        return sum;
    }
}

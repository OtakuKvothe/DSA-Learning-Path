//https://leetcode.com/problems/single-number-ii/
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int[] bin = new int[64];
        for(int num: nums){
            int t=Math.abs(num);
            int pos = 0;
            while(t>0){
                bin[bin.length-1-pos] += t%2;
                bin[bin.length-1-pos] %= 3;
                t=t/2;
                pos++;
            }
            if(num < 0){
                bin[0] += 1;
                bin[0] %= 3;
            }
        }
        int res = 0;
        for(int i=1; i<bin.length; i++){
            res+=bin[i]*(int)Math.pow(2, bin.length-1-i);
        }
        if(res == 0){
            if(bin[0] == 0){
                return 0;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        return bin[0]==0?res:-res;
    }
}

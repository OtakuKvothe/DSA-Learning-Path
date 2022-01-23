//https://leetcode.com/problems/delete-and-earn/
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] b=new int[10002];
        for(int n: nums){
            b[n]+=n;
        }
        for(int i=2; i<b.length; i++){
            b[i]=Math.max(b[i-1], b[i-2]+b[i]);
        }
        return b[b.length-1];
    }
}

//https://leetcode.com/problems/squares-of-a-sorted-array
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i=nums.length-1, l=0, r=nums.length-1;
        while(l<=r){
            int x = Math.abs(nums[l]);
            int y = Math.abs(nums[r]);
            if(x>=y){
                res[i--]=x*x;
                l++;
            }else{
                res[i--]=y*y;
                r--;
            }
        }
        return res;
    }
}

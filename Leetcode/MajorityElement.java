//https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int m = nums[0], c=0;
        for(int i=0; i<nums.length; i++){
            if(c==0){
                m=nums[i];
                c=1;
            }else if(m==nums[i]) c++;
            else c--;
        }
        return m;
    }
}

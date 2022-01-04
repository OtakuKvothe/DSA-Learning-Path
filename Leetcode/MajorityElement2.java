//https://leetcode.com/problems/majority-element-ii/
import java.util.LinkedList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new LinkedList<>();
        if(nums.length==1){
            res.add(nums[0]);
            return res;
        }
        int ca1=0, ca2=1, c1=0, c2=0;
        for(int i: nums){
            if(i==ca1) c1++;
            else if(i==ca2) c2++;
            else if(c1==0){
                ca1=i;
                c1=1;
            }else if(c2==0){
                ca2=i;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }
        c1=0; c2=0;
        for(int i: nums){
            if(i==ca1) c1++;
            else if(i==ca2) c2++;
        }
        if(c1>nums.length/3) res.add(ca1);
        if(c2>nums.length/3) res.add(ca2);
        return res;
    }
}

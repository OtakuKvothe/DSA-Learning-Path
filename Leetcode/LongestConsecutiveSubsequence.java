//https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> s=new HashSet<>();
        for(int i: nums) s.add(i);
        int res=0;
        for(Integer i: nums){
            int l=i-1;
            int r=i+1;
            while(s.remove(l)) l--;
            while(s.remove(r)) r++;
            res=Math.max(res, r-l-1);
            if(s.isEmpty()) return res;
        }
        return res;
    }
}

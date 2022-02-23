//https://leetcode.com/problems/minimize-deviation-in-array
import java.util.TreeSet;

public class MinimizeDeviationArray {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums){
            if(num % 2 == 0){
                set.add(num);
            }else{
                set.add(num*2);
            }
        }
        int res = Integer.MAX_VALUE;
        while(true){
            int max = set.last();
            res = Math.min(res, max - set.first());
            if(max % 2 == 1) break;
            else {
                set.remove(max);
                set.add(max/2);
            }
        }
        return res;
    }
}

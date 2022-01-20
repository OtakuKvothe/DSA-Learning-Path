//https://leetcode.com/problems/minimum-time-difference/
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()<=1) return 0;
        int[] times = new int[24*60];
        Arrays.fill(times, 0);
        for(String time: timePoints){
            String[] t = time.split(":");
            int hrs = Integer.parseInt(t[0]);
            System.out.println(hrs);
            int mins = Integer.parseInt(t[1]);
            System.out.println(mins);
            times[hrs*60+mins]++;
            if(times[hrs*60+mins]>1) return 0;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (times[i]>0) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
}

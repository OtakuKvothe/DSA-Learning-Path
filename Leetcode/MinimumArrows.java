//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
import java.util.Arrays;

public class MinimumArrows {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        for(int[] x: points){
            System.out.println(x[1]);
        }
        int count = 1;
        int pos = points[0][1];
        for(int i=1; i<points.length; i++){
            System.out.println(pos>=points[i][0]);
            if(pos>=points[i][0]) continue;
            count++;
            pos=points[i][1];
        }
        return count;
    }
}

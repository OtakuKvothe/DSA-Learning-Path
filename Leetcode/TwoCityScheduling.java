//https://leetcode.com/problems/two-city-scheduling
import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> {
            return Integer.compare(a[0]-a[1], b[0]-b[1]); 
        });
        
        int res = 0;
        for(int i=0; i<costs.length/2; i++) {
            res += costs[i][0] + costs[costs.length-1-i][1];
        }
        return res;
    }
}

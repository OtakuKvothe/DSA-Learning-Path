//https://leetcode.com/problems/min-cost-climbing-stairs
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2) return Math.min(cost[0], cost[1]);
        int twob=cost[0], oneb=cost[1];
        for(int i=2; i<cost.length; i++){
            int temp = oneb;
            oneb=cost[i]+Math.min(oneb, twob);
            twob=temp;
        }
        return Math.min(oneb, twob);
    }
}

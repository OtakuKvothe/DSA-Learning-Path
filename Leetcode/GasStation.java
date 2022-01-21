//https://leetcode.com/problems/gas-station
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int x=0, n=gas.length, sub=Integer.MAX_VALUE, st=0;
        for(int i=0; i<n; i++){
            x+=gas[i]-cost[i];
            if(x < sub){
                sub=x;
                st=i+1;
            }
        }
        return x<0?-1:st%n;
    }
}

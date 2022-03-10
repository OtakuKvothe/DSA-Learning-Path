//https://leetcode.com/problems/time-needed-to-inform-all-employees
import java.util.ArrayList;

public class TimeNeededToInformAllEmployees {
    //top-down dfs
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        int head=-1;
        for(int i=0; i<manager.length; i++){
            if(manager[i]==-1) {
                head = i;
            }
            else adj.get(manager[i]).add(i);
        }
        int res=dfs(adj, head, informTime, 0);
        return res; 
    }
    
    public int dfs(ArrayList<ArrayList<Integer>> adj, int curr, int[] time, int nTime){
        if(adj.get(curr).size()==0) return nTime+time[curr];
        int res = Integer.MIN_VALUE;
        for(Integer e: adj.get(curr)){
            res = Math.max(res, dfs(adj, e, time, nTime+time[curr]));
        }
        return res;
    }
}

class TimeNeededToInformAllEmployeesVer2 {
    //bottom-up
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }
    
    public int dfs(int i, int[] manager, int[] informTime){
        if(manager[i] != -1){
            informTime[i]+=dfs(manager[i], manager, informTime);
            manager[i]=-1;
        }
        return informTime[i];
    }
}

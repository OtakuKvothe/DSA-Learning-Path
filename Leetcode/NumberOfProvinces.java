import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int c=0;
        for(int i = 0; i<isConnected.length; i++){
            if(vis[i]) continue;
            c++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int r = q.poll();
                if(!vis[r]){
                    vis[r]=true;
                    for(int k = 0; k<isConnected[r].length; k++){
                        if(isConnected[r][k]==1){
                            q.add(k);
                        }
                    }
                }
            }
        }
        return c;
    }
}

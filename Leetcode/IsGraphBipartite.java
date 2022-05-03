//https://leetcode.com/problems/is-graph-bipartite

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        //-1 = blue
        //1 = red
        //0 = unmarked
        boolean[] vis = new boolean[n];       
        for(int i=0; i<n; i++) {
            if(vis[i]) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int curr = 1;
            vis[i] = true;
            col[i] = curr;
            while(!q.isEmpty()) {
                int l = q.size();
                curr = curr == 1 ? -1 : 1;
                while(l-->0) {
                    int v = q.poll();                    
                    for(int a: graph[v]) {
                        if(!vis[a]) {
                            q.add(a);
                            col[a] = curr;
                            vis[a] = true;
                        } else if(col[a] == col[v]) {
                            return false;
                        }
                    }
                }               
            }
        }
        return true;
    }
}

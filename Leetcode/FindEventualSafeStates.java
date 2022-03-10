//https://leetcode.com/problems/find-eventual-safe-states/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeStates {
    //topological sort with out-degree and reversed adjacency list
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] deg = new int[graph.length]; //out-degree
        List<Integer> adj[] = new ArrayList[graph.length]; //flipped graph
        for(int i=0; i<graph.length; i++){
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                deg[i]++;
                adj[graph[i][j]].add(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<deg.length; i++){
            if(deg[i]==0) res.add(i);
        }
        
        for(int i=0; i<res.size(); i++){
            for(Integer n: adj[res.get(i)]){
                if(--deg[n]==0){
                    res.add(n);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    //dfs with marking
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        int[] col = new int[graph.length]; //mark nodes 1, 2, 0
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(dfs(graph, col, i))
                res.add(i);
        }
        return res;
    }
    
    /**
    col[i]:
    i=0: not visited, i=1: visiting, i=2:visited and safe
    */
    
    public boolean dfs(int[][] graph, int[] col, int curr){
        if(col[curr] > 0){
            return col[curr] == 2;
        }
        col[curr] = 1;
        for(int i: graph[curr]){
            if(col[i]==2) continue;
            else if(col[i] == 1 || !dfs(graph, col, i))
                return false;
        }
        col[curr] = 2;
        return true;
    }
}

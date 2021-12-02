import java.util.ArrayList;

//1971. Find if path exists in Graph
public class FindPath {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(n==1) return true;
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        return locateEnd(adj, start, end, visited);
    }

    public boolean locateEnd(ArrayList<Integer> adj[], int curr, int end, boolean visited[]){
        boolean present = false;
        for(Integer i: adj[curr]){
            if(!visited[i]){
                visited[i]=true;
                if(i == end) return true;
                present = present || locateEnd(adj, i, end, visited);
            }
        }
        return present;
    }
}

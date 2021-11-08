import java.util.*;

public class DFS {
    private int V;

    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked") DFS(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]=new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void depthFirstSearchUtil(int v, boolean isVisited[]){
        isVisited[v]=true;
        System.out.println(v+" ");

        for(Integer i: adj[v]){
            if(!isVisited[i]){
                depthFirstSearchUtil(i, isVisited);
            }
        }
    }

    void depthFirstSearch(int v){
        boolean[] isVisited = new boolean[v];

        depthFirstSearchUtil(v, isVisited);

        /*
            //for dealing with disconnected graphs, where some vertices may not be reachable from one source, we try to do a DFS from each vertex, while maintaining the isVisited array.
            for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                depthFirstSearchUtil(i, visited);
        */
    }

    public static void main(String[] args) {
        //Driver function
    }
}

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

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
    }

    public static void main(String[] args) {
        //Driver function
    }
}

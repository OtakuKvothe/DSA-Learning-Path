import java.util.*;

public class BFS {
    private int V;
    private LinkedList<Integer> adj[]; //adjacency list

    BFS(int v){
        V=v;
        adj=new LinkedList[v];
        for(int i=0; i<v; ++i){
            adj[i]=new LinkedList<>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void breadthFirstSearch(int s){

        //to keep track of which vertices have been visited
        boolean[] isVisited = new boolean[V];

        //Queue like in level-order traversal of bst
        LinkedList<Integer> queue = new LinkedList<>();

        isVisited[s]=true;
        queue.add(s);

        while(!queue.isEmpty()){
            s=queue.poll();
            System.out.println(s+" ");

            for(int i: adj[s]){
                if(!isVisited[i]){
                    isVisited[i]=true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        //Driver method
    }
}

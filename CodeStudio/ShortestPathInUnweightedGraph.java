
//https://www.codingninjas.com/codestudio/problems/shortest-path-in-an-unweighted-graph_981297?topList=top-amazon-coding-interview-questions&leftPanelTab=0
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // Write your code here.
        LinkedList<Integer> adj[] = new LinkedList[n + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < adj[curr].size(); i++) {
                int next = adj[curr].get(i);
                if (!vis[next]) {
                    vis[next] = true;
                    parent[next] = curr;
                    q.add(next);
                }
            }
        }
        path.add(t);
        int curr = t;
        while (parent[curr] != -1) {
            curr = parent[curr];
            path.add(0, curr);
        }
        return path;
    }
}

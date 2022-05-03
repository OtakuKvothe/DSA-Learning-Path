import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[N-1][2];
            for(int i_edges = 0; i_edges < N-1; i_edges++)
            {
            	String[] arr_edges = br.readLine().split(" ");
            	for(int j_edges = 0; j_edges < arr_edges.length; j_edges++)
            	{
            		edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
            	}
            }

            int out_ = solve(N, edges);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }

    static int solve(int N, int[][] edges){
       // Write your code here
        int res = Integer.MAX_VALUE;

        int tot = 0;

        for(int i=1; i<=N; i++) {
            tot ^= i;
        }

        Set<Integer> graph[] = new HashSet[N+1];
        for(int i=0; i<=N; i++) {
            graph[i] = new HashSet<Integer>();
        }

        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for(int i=0; i<edges.length-1; i++) {
            for(int j=i+1; j<edges.length; j++) {
                graph[edges[i][0]].remove(edges[i][1]);
                graph[edges[i][1]].remove(edges[i][0]);
                graph[edges[j][0]].remove(edges[j][1]);
                graph[edges[j][1]].remove(edges[j][0]);

                int xors[] = bfs(graph);
                res = Math.min(res, max(xors[0], xors[1], xors[2]) - min(xors[0], xors[1], xors[2]));

                graph[edges[i][0]].add(edges[i][1]);
                graph[edges[i][1]].add(edges[i][0]);
                graph[edges[j][0]].add(edges[j][1]);
                graph[edges[j][1]].add(edges[j][0]);
            }
        }

        return res;   
    }

    static int[] bfs(Set<Integer> graph[]) {
        int xors[] = new int[3], x = 0;
        boolean[] vis = new boolean[graph.length];
        for(int i=1; i<graph.length && x<3; i++) {
            int res = 0;
            if(vis[i]) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()) {
                int v = q.poll();
                vis[v] = true;
                xors[x] ^= v;
                for(Integer n: graph[v]) {
                    if(!vis[n]) q.add(n);
                }
            }
            x++;
        }
        return xors;
    }

    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
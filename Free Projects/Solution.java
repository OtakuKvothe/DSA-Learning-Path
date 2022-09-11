import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("C:/Users/Desktop/Documents/GitHub/DSA-Learning-Path/Free Projects/input01.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Scanner sc = new Scanner(fr);
        int n = sc.nextInt();
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int[] vals = new int[n];
        for(int i=0; i<n-1; i++) {
            int a = sc.nextInt()-1, b = sc.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        for(int i=0; i<n; i++) {
            vals[i] = sc.nextInt();
        }
        boolean[] vis = new boolean[n];
        vis[0] = true;
        long res = dfs(adj, vals, vis, 0);
        System.out.println(res);
        sc.close();
    }
    
    public static long dfs(ArrayList<Integer> adj[], int[] vals, boolean[] vis, int curr) {
        if(adj[curr].size() == 1) {
            return vals[curr];
        }
        
        long currMax = vals[curr], childMax = Long.MIN_VALUE;
        for(Integer next: adj[curr]) {
            if(next>=0 && next < vis.length && !vis[next]) {
                vis[next] = true;
                long newMax = dfs(adj, vals, vis, next);
                childMax = Math.max(childMax, newMax);
                currMax += newMax;
            }
        }
        
        return Math.max(currMax, childMax);
    }
}
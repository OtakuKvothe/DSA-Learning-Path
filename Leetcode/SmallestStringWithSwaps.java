
//https://leetcode.com/problems/smallest-string-with-swaps/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int l = s.length();
        List<Integer> adj[] = new ArrayList[l];
        for (int i = 0; i < l; i++)
            adj[i] = new ArrayList<Integer>();
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).get(0) == pairs.get(i).get(1))
                continue;
            adj[pairs.get(i).get(0)].add(pairs.get(i).get(1));
            adj[pairs.get(i).get(1)].add(pairs.get(i).get(0));
        }
        boolean[] vis = new boolean[l];
        char[] res = new char[l];
        for (int i = 0; i < l; i++) {
            int pos = i;
            if (!vis[pos]) {
                PriorityQueue<Integer> ind = new PriorityQueue<>();
                PriorityQueue<Character> chars = new PriorityQueue<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (Integer neigh : adj[node]) {
                        if (!vis[neigh]) {
                            q.add(neigh);
                            vis[neigh] = true;
                        }
                    }
                    ind.add(node);
                    chars.add(s.charAt(node));
                }
                while (!ind.isEmpty() && !chars.isEmpty()) {
                    res[ind.poll()] = chars.poll();
                }
            }
        }
        return new String(res);
    }
}

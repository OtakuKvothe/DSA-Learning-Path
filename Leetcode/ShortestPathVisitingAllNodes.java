
//https://leetcode.com/problems/shortest-path-visiting-all-nodes
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        // dp[starting point of traversal][bitmask for keeping track of which nodes have
        // been visited]
        int[][] dp = new int[graph.length][1 << graph.length];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            q.add(new int[] { i, 1 << i });
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curr = node[0];
            int mask = node[1];
            for (int next : graph[curr]) {
                int nextMask = mask | 1 << next;
                if (dp[next][nextMask] > dp[curr][mask] + 1) {
                    dp[next][nextMask] = dp[curr][mask] + 1;
                    q.add(new int[] { next, nextMask });
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int[] lev : dp) {
            res = Math.min(res, lev[(1 << graph.length) - 1]);
        }
        return res;
    }
}

// https://leetcode.com/problems/network-delay-time

import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;
        
        for(int i=1; i<n+1; i++) {
            for(int[] time: times) {
                int u = time[0], v = time[1], w = time[2];
                
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        int res = 0;
        for(int dis: dist) {
            if(dis == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, dis);
        }
        
        return res;
    }
}

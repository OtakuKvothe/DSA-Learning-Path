//https://leetcode.com/problems/min-cost-to-connect-all-points

public class MinimumCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int res = 0, n = points.length;
        HashSet<Integer> mst = new HashSet<>();
        mst.add(0);
        int[] dist = new int[n];

        //we are starting from points[0], so we are calculating distance of all points from point[0]
        for(int i=0; i<n; i++) {
            dist[i] = dist(points, 0, i);
        }
        
        while(mst.size() != n) {
            int tmp = -1;
            
            for(int i=0; i<n; i++) {
                if(!mst.contains(i) && (tmp == -1 || dist[i] < dist[tmp])) {
                    tmp = i;
                }
            }
            
            mst.add(tmp);
            res += dist[tmp];
            
            //here we are calculating distance of all unvisited nodes from point tmp
            for(int i=0; i<n; i++) {
                if(!mst.contains(i)) {
                    dist[i] = Math.min(dist[i], dist(points, tmp, i));
                }
            }
        }
        
        return res;
    }
    
    public int dist(int[][] points, int a, int b) {
        return Math.abs(points[a][0]-points[b][0]) + Math.abs(points[a][1]-points[b][1]);
    }
}

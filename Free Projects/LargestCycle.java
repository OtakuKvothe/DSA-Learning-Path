import java.util.Arrays;
import java.util.HashSet;

public class LargestCycle {
    static HashSet<Integer> vis;
    static int[] dist;
    static int length;
    static int res;
    
    public static int findLongestCycle(int[] arr) {
        // Write your code here
        vis = new HashSet<Integer>();
        dist = new int[arr.length];
        Arrays.fill(dist, -1);
        length = 0;
        res = -1;
        
        for(int i=0; i<arr.length; i++) {
            if(!vis.contains(i)) {
                length = 0;
                dfs(arr, i);
            }
        }
        
        return res;
    }
    
    public static void dfs(int[] arr, int i) {
        if(i == -1) 
            return;
        
        if(vis.contains(i))
            return;
        
        if(dist[i] != -1) {
            res = Math.max(res, length - dist[i]);
            vis.add(i);
            return;
        }
        
        dist[i] = length;
        length++;
        
        dfs(arr, arr[i]);
        
        vis.add(i);
        dist[i] = -1;
    }
}

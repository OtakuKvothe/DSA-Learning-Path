//https://leetcode.com/problems/course-schedule-ii
import java.util.ArrayList;

public class CourseSchedule2 {
    public int[] findOrder(int n, int[][] prerequisites) {
        
        //prepeare adjacency list
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<>();
        }
        
        for(int[] p: prerequisites){
            adj[p[1]].add(p[0]);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        //in-degree (Kahn's algo)
        int[] deg = new int[n];
        for(int i=0; i<n; i++){
            for(Integer m: adj[i]){
                deg[m]++;
            }
        }

        for(int i=0; i<n; i++){
            if(deg[i]==0) {
                res.add(i);
            }
        }
        
        //topo sort
        for(int i=0; i<res.size(); i++){
            for(Integer m: adj[res.get(i)]){
                if(--deg[m]==0){
                    res.add(m);
                }
            }
        }
        
        //if couldn't finish all courses
        if(res.size() != n) return new int[]{};
        
        //convert res list to array
        int[] o = new int[res.size()];
        int i=0;
        for(Integer x: res){
            o[i++]=x;
        }
        return o;
    }
}

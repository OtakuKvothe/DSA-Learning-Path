//https://leetcode.com/problems/course-schedule
import java.util.ArrayList;

//This problem is plain and simple topological sort

public class CourseSchedule {
    public boolean canFinish(int n, int[][] pre) {
        //adjacency list
        ArrayList<Integer> adj[]=new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<>();
        }
        //degrees of each node
        int[] deg = new int[n];
        //to store the bfs order of the graph
        ArrayList<Integer> bfs = new ArrayList<>();
        //converting the input to adjacency list and calculate degree of each node
        for(int[] e: pre){
            adj[e[1]].add(e[0]);
            deg[e[0]]++;
        }
        //the nodes with degree zero (or the courses which have no prerequisites) are to be visited first
        for(int i=0; i<n; i++){
            if(deg[i]==0){
                bfs.add(i);
            }
        }
        //visit each of the children and add to bfs list in ascending order of their degree
        for(int i=0; i<bfs.size(); i++){
            for(Integer j: adj[bfs.get(i)]){
                if(--deg[j] == 0) bfs.add(j);
            }
        }
        return bfs.size() == n;
    }
}

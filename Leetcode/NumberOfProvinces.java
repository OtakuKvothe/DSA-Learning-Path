import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {

    //bfs
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int c=0;
        for(int i = 0; i<isConnected.length; i++){
            if(vis[i]) continue;
            c++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int r = q.poll();
                if(!vis[r]){
                    vis[r]=true;
                    for(int k = 0; k<isConnected[r].length; k++){
                        if(isConnected[r][k]==1){
                            q.add(k);
                        }
                    }
                }
            }
        }
        return c;
    }

    //union-find
    /**
     * public int findCircleNum(int[][] mat) {
        int[] parent = new int[mat.length];
        int[] size = new int[mat.length];
        
        for(int i=0; i<mat.length; i++){
            parent[i]=i;
            size[i]=1;
        }
        
        int res = mat.length;
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if(p1 != p2){
                        if(size[p1] < size[p2]){
                            size[p2]+=size[p1];
                            parent[p1]=p2;
                        }else{
                            size[p1]+=size[p2];
                            parent[p2]=p1;
                        }
                        res--;
                    }
                }
            }
        }
        return res;
    }
    
    public int find(int[] parent, int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
     */
}

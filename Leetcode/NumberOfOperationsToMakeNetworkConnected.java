//https://leetcode.com/problems/number-of-operations-to-make-network-connected
public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] con) {
        if(con.length < n-1) return -1;
        int[] parent = new int[n];
        int[] size = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        int res = n;
        
        for(int[] c: con){
            int p1 = find(parent, c[0]);
            int p2 = find(parent, c[1]);
            
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
        
        return res-1;
    }
    
    public int find(int[] parent, int i){
        if(i == parent[i]) return i;
        return parent[i] = find(parent, parent[i]);
    }
}

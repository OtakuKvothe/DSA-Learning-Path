public class RedundantConnection {
    int[] root;
    int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        root = new int[n+1];
        rank = new int[n+1];
        for(int i=1; i<=n; i++) {
            root[i] = i;
        }
        
        int[] res = new int[2];
        
        for(int[] edge: edges) {
            if(find(edge[0]) == find(edge[1])) {
                res = edge;
            } else {
                union(edge[0], edge[1]);
            }
        }
        
        return res;
    }
    
    public int find(int node) {
        if(node == root[node]) {
            return node;
        }
        return root[node] = find(root[node]);
    }
    
    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1 == root2) {
            return;
        } else if(rank[root1] < rank[root2]) {
            root[root1] = root2;
        } else if(rank[root1] > rank[root2]) {
            root[root2] = root1;
        } else {
            root[root2] = root1;
            rank[root1]++;
        }
    }
}

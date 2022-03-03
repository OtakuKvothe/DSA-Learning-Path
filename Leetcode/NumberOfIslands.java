//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    res++;
                    dfs(grid, vis, i, j);
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid, boolean[][] vis, int i, int j){
        vis[i][j]=true;
        if(i-1>=0&&grid[i-1][j]=='1'&&!vis[i-1][j]) dfs(grid, vis, i-1, j);
        if(i+1<grid.length&&grid[i+1][j]=='1'&&!vis[i+1][j]) dfs(grid, vis, i+1, j);
        if(j-1>=0&&grid[i][j-1]=='1'&&!vis[i][j-1]) dfs(grid, vis, i, j-1);
        if(j+1<grid[0].length&&grid[i][j+1]=='1'&&!vis[i][j+1]) dfs(grid, vis, i, j+1);
    }
}

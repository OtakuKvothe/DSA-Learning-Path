//https://leetcode.com/problems/max-increase-to-keep-city-skyline/
public class MaxIncreaseSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, mr[] = new int[n], mc[] = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mr[i]=Math.max(mr[i], grid[i][j]);
                mc[i]=Math.max(mc[i], grid[j][i]);
            }
        }
        int c=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                c+=Math.max(grid[i][j], Math.min(mc[j], mr[i]))-grid[i][j];
                //grid[i][j] = Math.max(grid[i][j], Math.min(mc[j], mr[i]));
            }
        }
        return c;
    }
}

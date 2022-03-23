//https://leetcode.com/problems/as-far-from-land-as-possible
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if(q.isEmpty() || q.size() == grid.length * grid[0].length) {
            return -1;
        }
        
        int res = 0;
        while(!q.isEmpty()) {
            int l = q.size();
            while(l-- > 0) {
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1) {
                        continue;
                    }                
                    grid[row][col] = 1;
                    q.add(new int[]{row, col});
                }
            }
            res++;
        }
        
        return res-1;
    }
}

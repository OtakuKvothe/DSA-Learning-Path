
//https://leetcode.com/problems/shortest-bridge
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        boolean f = false;
        for (int i = 0; i < grid.length; i++) {
            if (f)
                break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, q, dirs, vis, i, j);
                    f = true;
                    break;
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            while (l-- > 0) {
                int[] cell = q.poll();
                for (int d[] : dirs) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !vis[x][y]) {
                        if (grid[x][y] == 1)
                            return res;
                        else {
                            q.add(new int[] { x, y });
                            vis[x][y] = true;
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public void dfs(int[][] grid, Queue<int[]> q, int[][] dirs, boolean[][] vis, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0)
            return;

        vis[i][j] = true;
        q.add(new int[] { i, j });
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(grid, q, dirs, vis, x, y);
        }
    }
}

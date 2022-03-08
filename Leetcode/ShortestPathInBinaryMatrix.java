
//https://leetcode.com/problems/shortest-path-in-binary-matrix
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        q.add(new int[] { 0, 0 });
        vis[0][0] = true;

        int res = 0;

        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int[] cell = q.poll();
                if (cell[0] == grid.length - 1 && cell[1] == grid[0].length - 1)
                    return res + 1;
                for (int j = 0; j < dir.length; j++) {
                    int x = cell[0] + dir[j][0];
                    int y = cell[1] + dir[j][1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !vis[x][y] && grid[x][y] == 0) {
                        q.add(new int[] { x, y });
                        vis[x][y] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}

//https://leetcode.com/problems/path-with-minimum-effort

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    class Vertex {
        public int x, y, e;

        public Vertex(int x, int y, int e) {
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int n = heights.length, m = heights[0].length;
        int[][] eff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                eff[i][j] = Integer.MAX_VALUE;
            }
        }

        boolean[][] vis = new boolean[n][m];

        PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.e, b.e);
        });

        pq.add(new Vertex(0, 0, 0));

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            int x = v.x, y = v.y, e = v.e;

            if (vis[x][y])
                continue;

            if (x == n - 1 && y == m - 1)
                return e;

            vis[x][y] = true;
            for (int dir[] : dirs) {
                int r = x + dir[0], c = y + dir[1];
                if (r >= 0 && r < n && c >= 0 && c < m && !vis[r][c]) {
                    int ef = Math.max(e, Math.abs(heights[r][c] - heights[x][y]));
                    if (ef < eff[r][c]) {
                        eff[r][c] = ef;
                        pq.add(new Vertex(r, c, ef));
                    }
                }
            }
        }

        return 0;
    }
}

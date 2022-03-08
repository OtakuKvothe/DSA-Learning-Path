
//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze
import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] ent) {
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> q = new LinkedList<>();
        for (int[] d : dirs) {
            int x = ent[0] + d[0];
            int y = ent[1] + d[1];
            if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.') {
                maze[x][y] = '+';
                q.add(new int[] { x, y });
            }
        }
        maze[ent[0]][ent[1]] = '+';
        int res = 0;
        while (!q.isEmpty()) {
            int l = q.size();
            while (l-- > 0) {
                int[] cell = q.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length) {
                        if (maze[x][y] == '.') {
                            maze[x][y] = '+';
                            q.add(new int[] { x, y });
                        }
                    } else {
                        return res + 1;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}

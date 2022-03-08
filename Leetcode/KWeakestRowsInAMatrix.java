//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
import java.util.PriorityQueue;

public class KWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] cc = new int[mat.length];
        int[] res = new int[k];
        for (int i = 0; i < mat.length; i++) {
            int lo = 0, hi = mat[i].length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (mat[i][mid] == 1) {
                    lo = mid + 1;
                } else if (mat[i][mid] == 0) {
                    hi = mid - 1;
                }
            }
            cc[i] = lo + 1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            if (cc[a] != cc[b]) {
                return Integer.compare(cc[a], cc[b]);
            } else {
                return Integer.compare(a, b);
            }
        });
        for (int i = 0; i < cc.length; i++)
            q.add(i);
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}

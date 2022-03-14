
//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
import java.util.LinkedList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new LinkedList<>();
        int[] deg = new int[n];
        for (List<Integer> k : edges) {
            deg[k.get(1)]++;
        }
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0)
                res.add(i);
        }
        return res;
    }
}

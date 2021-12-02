import java.util.LinkedList;
import java.util.List;

public class DAGTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        path.add(0);
        findPath(res, path, graph, 0);
        return res;
    }

    public void findPath(List<List<Integer>> res, List<Integer> path, int[][] graph, int curr) {
        if (curr == graph.length - 1) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (Integer i : graph[curr]) {
            path.add(i);
            findPath(res, path, graph, i);
            path.remove(path.size() - 1);
        }
    }
}

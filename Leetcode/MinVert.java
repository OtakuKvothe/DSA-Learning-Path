import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinVert {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new LinkedList<>();
        boolean vis[]=new boolean[n];
        for(List<Integer> k: edges){
            vis[k.get(1)]=true;
        }
        for(int i=0; i<vis.length; i++){
            if(!vis[i]) res.add(i);
        }
        return res;
    }
}

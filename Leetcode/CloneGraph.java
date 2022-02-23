//https://leetcode.com/problems/clone-graph
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return helper(node, new HashMap<>());
    }
    
    public Node helper(Node node, HashMap<Node, Node> vis){
        if(node == null) return null;
        Node tmp = new Node(node.val);
        vis.put(node, tmp);
        for(Node neig: node.neighbors){
            if(!vis.containsKey(neig)){
                Node neic = helper(neig, vis);
                tmp.neighbors.add(neic);
            }else{
                tmp.neighbors.add(vis.get(neig));
            }
        }
        return tmp;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int l = q.size();
            while(l-- > 0) {
                Node t = q.poll();
                if(l>0) {
                    t.next = q.peek();
                } 
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
        }       
        return root;
    }
}

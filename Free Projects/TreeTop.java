import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TreeTop {
    public static void topView(Node root) {
        /*
         * Here we create a custom class to store each tree node along with a designated
         * level which are used to denote how much farther each node is to teh left or
         * right of the root node. The root node is at 0, its left child at -1, right
         * child at +1 and so on.
         */
        class qObj {
            Node node;
            int lvl;

            public qObj(Node node, int lvl) {
                this.node = node;
                this.lvl = lvl;
            }
        }
        /*
         * The objective of the queue is to establish an order for visiting nodes. The
         * order is preorder. Each node is assigned a lvl value relative to it's parent.
         */
        Queue<qObj> q = new LinkedList<>();

        // TreeMap to present the node values in sorted order of their lvl values, so
        // that we have neatly ordered elements form leftmost to rightmost.
        TreeMap<Integer, Node> map = new TreeMap<>();

        if (root == null) {
            return;
        } else {
            q.add(new qObj(root, 0));
        }

        while (!q.isEmpty()) {
            qObj qt = q.poll();

            /*
             * Whenever we have a node whose lvl value has not been reached, it is added to
             * map. This always works because of two considerations: there is only one
             * unique map entry for every possible lv value and that the upper nodes are
             * visited before the lower nodes.
             * 
             * Any 2 nodes with same lvl value, the node lower in the hirearchy will not
             * enter the map because the node which is higher in the hierarchy has already
             * entered the map.
             * 
             * Conversely, anytime a node at lower levels achieves a lvl value not reached
             * by the upper level nodes, it may enter the map.
             */
            if (!map.containsKey(qt.lvl)) {
                map.put(qt.lvl, qt.node);
            }

            if (qt.node.left != null) {
                q.add(new qObj(qt.node.left, qt.lvl - 1));
            }

            if (qt.node.right != null) {
                q.add(new qObj(qt.node.right, qt.lvl + 1));
            }
        }

        // printing out the sorted values
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
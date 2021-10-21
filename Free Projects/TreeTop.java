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

    /*
     * 
     * class Node int data; Node left; Node right;
     */
    public static void topView(Node root) {
        /*
         * Here we create a custom class to store each tree node along with a designated
         * level
         */
        class qObj {
            Node node;
            int lvl;

            public qObj(Node node, int lvl) {
                this.node = node;
                this.lvl = lvl;
            }
        }

        Queue<qObj> q = new LinkedList<>();
        TreeMap<Integer, Node> map = new TreeMap<>();

        if (root == null) {
            return;
        } else {
            q.add(new qObj(root, 0));
        }

        while (!q.isEmpty()) {
            qObj qt = q.poll();
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
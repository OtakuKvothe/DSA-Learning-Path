import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeOfSpace {

    class TreeNode {

        boolean isLocked;
        boolean canLock;
        boolean hasLockedChildren;
        int lockedChildCount;
        int timesLocked;
        String value;
        String lockingUser;
        TreeNode[] children;
        TreeNode parent;

        public TreeNode(int m, String value, TreeNode parent) {
            children = new TreeNode[m];
            isLocked = false;
            canLock = true;
            lockingUser = "";
            this.value = value;
            this.parent = parent;
            this.hasLockedChildren = false;
            lockedChildCount = 0;
            timesLocked = 0;
        }
    }

    HashMap<String, TreeNode> map;

    public TreeOfSpace() {
        map = new HashMap<String, TreeNode>();
    }

    public TreeNode makeTree(int m, String[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(m, arr[i++], null);
        q.add(root);
        map.put(root.value, root);
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            for (int j = 0; j < m && i < arr.length; j++, i++) {
                TreeNode next = new TreeNode(m, arr[i], curr);
                curr.children[j] = next;
                q.add(next);
                map.put(next.value, next);
            }
        }
        return root;
    }

    public List<Boolean> makeQueries(String[] queries) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            String[] parts = query.split(" ");
            switch (parts[0]) {
                case "1":
                    result.add(lock(parts[1], parts[2]));
                    break;

                case "2":
                    result.add(unlock(parts[1], parts[2]));
                    break;

                case "3":
                    result.add(upgrade(parts[1], parts[2]));
                    break;

                default:
                    result.add(false);
            }
        }

        return result;
    }

    private void setChildrenNotLockable(TreeNode root) {
        if (root == null) {
            return;
        }

        root.canLock = false;

        for (TreeNode child : root.children) {
            setChildrenNotLockable(child);
        }
    }

    private void setChildrenLockable(TreeNode root) {
        if (root == null) {
            return;
        }

        root.canLock = true;

        for (TreeNode child : root.children) {
            setChildrenLockable(child);
        }
    }

    private boolean isChildernLocked(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.isLocked) {
            return true;
        }

        boolean res = false;
        for (int i = 0; i < root.children.length; i++) {
            res |= isChildernLocked(root.children[i]);
            if (res) {
                return true;
            }
        }

        return res;
    }

    public void countLockedNodes(TreeNode node, String user, int[] count, HashSet<TreeNode> lockedNodes) {
        if (node == null) {
            return;
        }

        if (node.isLocked) {
            if (node.lockingUser.equals(user)) {
                count[0]++;
                lockedNodes.add(node);
            } else {
                count[1]++;
            }
        }

        for (TreeNode child : node.children) {
            countLockedNodes(child, user, count, lockedNodes);
        }
    }

    private boolean isParentLocked(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.isLocked == true) {
            return true;
        }

        return isParentLocked(node.parent);
    }

    private boolean setHasLockedChildren(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.timesLocked > 0) {
            return false;
        }

        boolean res = setHasLockedChildren(node.parent);

        if (res) {
            if (node.timesLocked > 0 || node.lockedChildCount > 0) {
                revert(node.parent);
                return false;
            }
            node.lockedChildCount++;
        }

        return res;
    }

    private void revert(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.lockedChildCount > 0)
            node.lockedChildCount--;
        revert(node.parent);
    }

    public boolean lock(String nodeName, String user) {
        if (!map.containsKey(nodeName)) {
            return false;
        }

        TreeNode node = map.get(nodeName);

        if (node.timesLocked > 0 || node.lockedChildCount > 0) {
            return false;
        }

        boolean isChildrenLocked = node.lockedChildCount > 0;

        if (!isChildrenLocked) {
            node.timesLocked++;
            node.lockingUser = user;
            boolean res = this.setHasLockedChildren(node.parent);
            if (node.lockedChildCount > 0 || !res || node.timesLocked > 1) {
                node.timesLocked--;
                if ((node.lockedChildCount > 0 && res) || node.timesLocked >= 1) {
                    revert(node.parent);
                }                
                if(node.timesLocked == 0) node.lockingUser = "";
                return false;
            }
            return res;
        }
        return false;
    }

    public boolean unlock(String nodeName, String user) {
        if (!map.containsKey(nodeName)) {
            return false;
        }

        TreeNode node = map.get(nodeName);

        if (!node.isLocked) {
            return false;
        }

        if (!node.lockingUser.equals(user)) {
            return false;
        }

        node.isLocked = false;
        node.lockingUser = "";
        node.canLock = true;
        setChildrenLockable(node);

        return true;
    }

    public boolean upgrade(String nodeName, String user) {
        if (!map.containsKey(nodeName)) {
            return false;
        }

        TreeNode node = map.get(nodeName);

        if (node.isLocked) {
            return false;
        }

        if (!node.canLock) {
            return false;
        }

        int[] count = new int[2]; // {number of nodes locked by current user, number of nodes locked by other
                                  // user}
        HashSet<TreeNode> lockedNodes = new HashSet<>();

        countLockedNodes(node, user, count, lockedNodes);

        if (count[0] > 0 && count[1] == 0) {
            for (TreeNode lockedNode : lockedNodes) {
                lockedNode.isLocked = false;
                lockedNode.lockingUser = "";
            }
            node.isLocked = true;
            node.lockingUser = user;
            node.canLock = false;
            setChildrenNotLockable(node);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String arr[] = { "World", "Asia", "Africa", "China", "India", "SouthAfrica", "Egypt" };
        String queries[] = { "1 China 9", "1 India 9", "3 Asia 9", "2 India 9", "2 Asia 9" };
        int n = 7, m = 2;

        TreeOfSpace ob = new TreeOfSpace();
        TreeNode root = ob.makeTree(m, arr);

        System.out.println(ob.makeQueries(queries));
    }
}

/**
 * Input: N = 7, M = 2, nodes = {"World", "Asia", "Africa", "China", "India",
 * "SouthAfrica", "Egypt"},
 * queries = {"1 China 9", "1 India 9", "3 Asia 9", "2 India 9", "2 Asia 9"}
 * Output: true true true false true
 * 
 * Input: N = 3, M = 2, nodes = [‘World’, ‘China’, ‘India’],
 * queries = [‘3 India 1’, ‘1 World 9’]
 * Output: false true
 */

class TreeNode {
    int lockedChildCount;
    int timesLocked;
    String value;
    String lockingUser;
    TreeNode parent;

    public TreeNode(int m, String value, TreeNode parent) {
        lockingUser = "";
        this.value = value;
        this.parent = parent;
        lockedChildCount = 0;
        timesLocked = 0;
    }
}
package TreeOfSpaceThreadSafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeOfSpace {

    TreeNode root;
    HashMap<String, TreeNode> map;
    TreeState treeState;

    public TreeOfSpace() {
        map = new HashMap<String, TreeNode>();
        root = null;
        treeState = TreeState.Idle;
    }

    public TreeOfSpace(int m, String[] nodes) {
        map = new HashMap<String, TreeNode>();
        root = makeTree(m, nodes);
        treeState = TreeState.Idle;
    }

    public TreeNode makeTree(int m, String[] arr) {
        Queue<TreeNode> q = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(m, arr[i++]);
        q.add(root);
        map.put(root.value, root);
        while(!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            for(int j=0; j<m && i<arr.length; j++, i++) {
                TreeNode next = new TreeNode(m, arr[i]);
                curr.children[j] = next;
                q.add(next);
                map.put(next.value, next);
            }
        }
        return root;
    }

    public List<Boolean> makeQueries(String[] queries) {
        List<Boolean> result = new ArrayList<>();
        for(String query: queries) {
            String[] parts = query.split(" ");
            switch(parts[0]) {
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
        if(root == null) {
            return;
        }

        root.canLock = false;

        for(TreeNode child: root.children) {
            setChildrenNotLockable(child);
        }
    }

    private void setChildrenLockable(TreeNode root) {
        if(root == null) {
            return;
        }

        root.canLock = true;

        for(TreeNode child: root.children) {
            setChildrenLockable(child);
        }
    }

    private boolean isChildernLocked(TreeNode root) {
        if(root == null) {
            return false;
        }

        if(root.isLocked) {
            return true;
        }

        boolean res = false;
        for(int i=0; i<root.children.length; i++) {
            res |= isChildernLocked(root.children[i]);
            if(res) {
                return true;
            }
        }

        return res;
    } 

    private void countLockedNodes(TreeNode node, String user, int[] count, HashSet<TreeNode> lockedNodes) {
        if(node == null) {
            return;
        }

        if(node.isLocked) {
            if(node.lockingUser.equals(user)) {
                count[0]++;
                lockedNodes.add(node);
            } else {
                count[1]++;
            }
        }

        for(TreeNode child: node.children) {
            countLockedNodes(child, user, count, lockedNodes);
        }
    }

    public boolean lock(String nodeName, String user) {
        if(!map.containsKey(nodeName)) {
            return false;
        }

        TreeNode node = map.get(nodeName);

        if(node.isLocked) {
            return false;
        }

        if(!node.canLock) {
            return false;
        }

        boolean isChildernLocked = isChildernLocked(node);

        if(!isChildernLocked) {
            node.isLocked = true;
            node.lockingUser = user;
            node.canLock = false;
            setChildrenNotLockable(node);
            return true;
        }

        return false;
    }

    public boolean unlock(String nodeName, String user) {
        if(!map.containsKey(nodeName)) {
            return false;
        }

        TreeNode node = map.get(nodeName);

        if(!node.isLocked) {
            return false;
        }

        if(!node.lockingUser.equals(user)) {
            return false;
        }

        node.isLocked = false;
        node.lockingUser = "";
        node.canLock = true;
        setChildrenLockable(node);

        return true;
    }

    public boolean upgrade(String nodeName, String user) {
        if(!map.containsKey(nodeName)) {
            return false;
        }

        TreeNode node = map.get(nodeName);

        if(node.isLocked) {
            return false;
        }

        if(!node.canLock) {
            return false;
        }

        int[] count = new int[2];
        HashSet<TreeNode> lockedNodes = new HashSet<>();

        countLockedNodes(node, user, count, lockedNodes);

        if(count[0] > 0 && count[1] == 0) {
            for(TreeNode lockedNode: lockedNodes) {
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
}

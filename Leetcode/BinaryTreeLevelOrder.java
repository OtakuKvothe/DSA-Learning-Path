
//https://leetcode.com/problems/binary-tree-level-order-traversal/
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> l = new LinkedList<>();
            while (n > 0) {
                TreeNode t = q.poll();
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
                l.add(t.val);
                n--;
            }
            res.add(l);
        }
        return res;
    }

    // dfs solution
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode node, int height, List<List<Integer>> res) {
        if (node == null)
            return;
        if (height >= res.size())
            res.add(new LinkedList<Integer>());
        res.get(height).add(node.val);
        dfs(node.left, height + 1, res);
        dfs(node.right, height + 1, res);
    }
}

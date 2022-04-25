//https://leetcode.com/problems/kth-smallest-element-in-a-bst

public class KthSmallestElementInABST {
    int res=0, n=0;
    
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    
    public void dfs(TreeNode node, int k) {
        if(node == null) return;
        dfs(node.left, k);
        n++;
        if(n == k) {
            res = node.val;
        }
        dfs(node.right, k);
    }
}

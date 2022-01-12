//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode node, int s){
        if(node == null) return 0;
        int x = dfs(node.left, s*2+node.val)+dfs(node.right, s*2+node.val);
        return x>0 ? x : s*2+node.val;
    }
}

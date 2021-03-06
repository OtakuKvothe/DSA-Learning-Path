//https://leetcode.com/problems/convert-bst-to-greater-tree/

public class ConvertBSTToGreaterTree {
    
    Integer sum = 0;
    
    public TreeNode convertBST(TreeNode root) {        
        dfs(root);
        return root;
    }
    
    public void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }
}

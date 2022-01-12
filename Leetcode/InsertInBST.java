//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        insert(root, val);
        return root;
    }
    
    public void insert(TreeNode node, int val){
        if(node.val > val){
            if(node.left != null) insert(node.left, val);
            else{
                node.left = new TreeNode(val);
            }
            return;
        }
        if(node.val < val){
            if(node.right != null) insert(node.right, val);
            else{
                node.right = new TreeNode(val);
            }
            return;
        }
    }
}

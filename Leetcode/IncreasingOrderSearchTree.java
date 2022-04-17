//https://leetcode.com/problems/increasing-order-search-tree/

import java.util.ArrayList;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(inorder, root);
        if(inorder.size() == 0) {
            return null;
        }
        TreeNode nh = new TreeNode(inorder.get(0)), node = nh;
        for(int i=1; i<inorder.size(); i++) {
            node.right = new TreeNode(inorder.get(i));
            node = node.right;
        }
        return nh;
    }
    
    public void inOrder(ArrayList<Integer> inorder, TreeNode node) {
        if(node == null) return;
        inOrder(inorder, node.left);
        inorder.add(node.val);
        inOrder(inorder, node.right);
    }
}

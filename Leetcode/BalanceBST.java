//https://leetcode.com/problems/balance-a-binary-search-tree/
import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        treeToList(nums, root);
        return listToTree(nums, 0, nums.size()-1);
    }
    
    public void treeToList(List<Integer> nums, TreeNode node){
        if(node==null) return;
        treeToList(nums, node.left);
        nums.add(node.val);
        treeToList(nums, node.right);
    }
    
    public TreeNode listToTree(List<Integer> nums, int l, int r){
        if(l>r) return null;
        int m=(l+r)/2;
        TreeNode node = new TreeNode(nums.get(m));
        node.left=listToTree(nums, l, m-1);
        node.right=listToTree(nums, m+1, r);
        return node;
    }
}

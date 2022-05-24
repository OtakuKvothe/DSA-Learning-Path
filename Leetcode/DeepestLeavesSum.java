//https://leetcode.com/problems/deepest-leaves-sum/

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        //int ht = height(root), lev = 0;
        int sum = 0;
        while(!q.isEmpty()) {
            int l = q.size();
            //lev++;
            sum = 0;
            while(l-- > 0) {
                TreeNode node = q.poll();
                //if(lev == ht)
                    sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return sum;
    }
    
    public int height(TreeNode node) {
        if(node == null) return 0;
        
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

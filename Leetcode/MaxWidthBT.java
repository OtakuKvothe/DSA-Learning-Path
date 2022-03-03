//https://leetcode.com/problems/maximum-width-of-binary-tree
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBT {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Integer> m = new HashMap<>();
        int res = 0;
        q.add(root);
        m.put(root, 1);
        while(!q.isEmpty()){
            int s = q.size(), l = 0, r = 0;
            for(int i=0; i<s; i++){
                TreeNode node = q.poll();
                if(i == 0) l=m.get(node);
                if(i == s-1) r=m.get(node);
                if(node.left != null){
                    m.put(node.left, m.get(node)*2);
                    q.add(node.left);
                }
                if(node.right != null){
                    m.put(node.right, m.get(node)*2+1);
                    q.add(node.right);
                }
            }
            res = Math.max(res, r-l+1);
        }        
        return res;
    }
}

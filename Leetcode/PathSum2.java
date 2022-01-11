//https://leetcode.com/problems/path-sum-ii
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<Integer>(), root, targetSum, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, TreeNode node, int target, int curr){
        if(node == null) return;
        
        list.add(node.val);
        
        if(curr+node.val==target&&node.left==null&&node.right==null){
            res.add(new LinkedList<>(list));
            list.remove(list.size()-1);
            return;
        }
        
        if(node.left != null){
            dfs(res, list, node.left, target, curr+node.val);
        }
        if(node.right != null){
            dfs(res, list, node.right, target, curr+node.val);
        }
        list.remove(list.size()-1);
    }
}

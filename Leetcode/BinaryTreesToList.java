//https://leetcode.com/problems/all-elements-in-two-binary-search-trees
import java.util.ArrayList;
import java.util.List;

public class BinaryTreesToList {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper(list1, root1);
        helper(list2, root2);
        List<Integer> res = new ArrayList<>();
        int p1=0, p2=0;
        int n1=list1.size(), n2=list2.size();
        while(p1<n1&&p2<n2){
            if(list1.get(p1)<list2.get(p2)){
                res.add(list1.get(p1++));
            }else{
                res.add(list2.get(p2++));
            }
        }
        while(p1<n1){
            res.add(list1.get(p1++));
        }
        while(p2<n2){
            res.add(list2.get(p2++));
        }
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode node){
        if(node == null) return;
        helper(res, node.left);
        res.add(node.val);
        helper(res, node.right);
    }
}

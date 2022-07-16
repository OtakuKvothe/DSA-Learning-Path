import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/maximum-binary-tree

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> st = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!st.isEmpty() && st.peek().val < nums[i]) {
                curr.left = st.pop();
            }
            if(!st.isEmpty()) {
                st.peek().right = curr;
            }
            st.push(curr);
        }
        return st.isEmpty() ? null : st.removeLast();
    }
}

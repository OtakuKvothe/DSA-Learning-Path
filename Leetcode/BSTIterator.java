//https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.Stack;

class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addLeft(root);
    }
    
    public void addLeft(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode p = stack.pop();
        addLeft(p.right);
        return p.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

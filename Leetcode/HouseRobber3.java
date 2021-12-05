public class HouseRobber3 {
    public int rob(TreeNode root){
        int res[]=robTree(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] robTree(TreeNode root) {
        if(root==null) return new int[2];
        
        int left[]=robTree(root.left);
        int right[]=robTree(root.right);
        int res[]=new int[2];
        
        res[0]=Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        res[1]=root.val+left[0]+right[0];
        
        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

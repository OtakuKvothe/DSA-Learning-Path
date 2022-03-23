//https://www.codingninjas.com/codestudio/problems/longest-univalue-path_985291?topList=top-amazon-coding-interview-questions&leftPanelTab=0
public class LongestUnivaluePath {
    static int length;
    
	public static int longestUnivaluePath(BinaryTreeNode root) {
		// Write your code here
        length = 0;
        path(root);
        return length;
	}
    
    public static int path(BinaryTreeNode root) {
        if(root == null) return 0;
        
        int left = path(root.left), right = path(root.right), 
        maxLeft = (root.left != null && root.left.data == root.data) ? left + 1 : 0, 
        maxRight = (root.right != null && root.right.data == root.data) ? right + 1 : 0;

        length = Math.max(length, maxLeft + maxRight);
        return Math.max(maxLeft, maxRight);
    }
}

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

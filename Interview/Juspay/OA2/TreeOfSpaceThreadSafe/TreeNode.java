package TreeOfSpaceThreadSafe;

public class TreeNode {
    boolean isLocked;
    boolean canLock;
    String value;
    String lockingUser;
    TreeNode[] children;

    public TreeNode(int m, String value) {
        children = new TreeNode[m];
        isLocked = false;
        canLock = true;
        lockingUser = "";
        this.value = value;
    }
}

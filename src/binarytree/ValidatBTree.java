package binarytree;

public class ValidatBTree {


    public static long low =Long.MAX_VALUE;
    public static long high =Long.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return helper(root,low,high);

    }

    private boolean helper(TreeNode root, long low, long high) {

        if(root.left.val > low || root.right.val < high )
            return false;

        return helper(root.left,root.val,high) &&helper(root.right,low,root.right.val);
    }
}

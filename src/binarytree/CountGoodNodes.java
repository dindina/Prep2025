package binarytree;

/*

https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.


 */
public class CountGoodNodes {

    int count =0;
    public static void main(String[] args) {
        System.out.println(new CountGoodNodes().goodNodes(TreeNode.getSampleTree()));
    }
    public int goodNodes(TreeNode root) {

        helper(root, Long.MIN_VALUE);
        return count;

    }

    private void helper(TreeNode root, long maxValue) {
        if (root == null)
            return;
        if(root.val > maxValue)
            count ++;
        helper(root.left,Math.max(root.val,maxValue));
        helper(root.right,Math.max(root.val,maxValue));
    }

}

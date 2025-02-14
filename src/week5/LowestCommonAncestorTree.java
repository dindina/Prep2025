package week5;

import binarytree.TreeNode;

public class LowestCommonAncestorTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();



        root.left = node1;
        node1.val = 2;
        root.right = node2;
        node2.val = 3;

        root.left.left = node3;
        node3.val = 4;
        root.left.right = node4;
        node4.val = 5;
        root.left.left.left = node5;
        node5.val = 6;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root ==p  || root ==q )
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;

    }
}

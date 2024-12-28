package week2;

import binarytree.TreeNode;

public class DiameterOfBinaryTree {

    int diameter;
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();



        root.left = node1;
        node1.val = 2;
        root.right = node2;
        node2.val = 3;

        root.left.left = node3;
        node3.val = 4;
        root.left.right = node4;
        node4.val = 5;

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null)
            return 0;

        height(root);
        return diameter;

    }

    public int height(TreeNode root )
    {
        if ( root == null)
            return 0;

        int left = height(root.left );

        int right = height(root.right );

        diameter = Math.max(diameter, left+right);

        return 1 + Math.max(left,right);

    }
}

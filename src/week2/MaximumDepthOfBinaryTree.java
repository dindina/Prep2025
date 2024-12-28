package week2;

import binarytree.TreeNode;
/*
https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class MaximumDepthOfBinaryTree {

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
        root.left.right.left = node5;
        node5.val = 6;
        System.out.println(new MaximumDepthOfBinaryTree().height(root));

    }
    public int height( TreeNode node)
    {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}

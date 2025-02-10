package week1;

import binarytree.TreeNode;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
Given a binary tree, determine if it is
height-balanced

A height-balanced binary tree is a binary tree in which the depth of
the two subtrees of every node never differs by more than one.


 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);
        // Check if the diffeence is 1 or less
        // check for all single nodes in left and right
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }



    public int height(TreeNode node)
    {
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.right),height(node.left));
    }

}

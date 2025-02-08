package week1;

import binarytree.TreeNode;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
Given a binary tree, determine if it is
height-balanced
.

 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);
        // Check the balance condition and recurse for left and right subtrees
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }



    public int height(TreeNode node)
    {
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.right),height(node.left));
    }

}

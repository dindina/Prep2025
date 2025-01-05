package week4;

import binarytree.TreeNode;

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidatBST {

    public boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE,Long.MAX_VALUE);

    }

    private boolean validate(TreeNode root, long minValue, long maxValue) {
        if(root == null)
            return true;
        if(root.val <= maxValue && root.val >= minValue)
            return true;
        return validate(root.left,minValue, root.val) && validate(root.right,root.val,maxValue);

    }
}

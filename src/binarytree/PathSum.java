package binarytree;

import com.sun.source.tree.Tree;

/*
https://leetcode.com/problems/path-sum/description/

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 */
public class PathSum {

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

        System.out.println(new PathSum().hasPathSum(root,7));

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        // leaf condition
        if(root.left == null && root.right == null && root.val == targetSum )
            return true;
        return helper(root,targetSum);

    }
    boolean helper(TreeNode root, int target)
    {
        if(root == null)
            return false;
        if(root.left  == null && root.right  == null && root.val == target)
            return true;
        return helper(root.right,target-root.val) ||  helper(root.left,target-root.val);

    }

}

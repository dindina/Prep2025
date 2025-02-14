package binarytree;

import com.sun.source.tree.Tree;

/*

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”

 */
public class LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p ,q);
        }
        else{
                return root;
            }


    }















    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor1(root.right,p,q);
        }
        else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor1(root.left,p,q);
        }
        else {
            return root;
        }
    }



    public TreeNode invert(TreeNode node){
        if ( node == null){
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);

        TreeNode temp = left;
        node.left = right;
        node.right = temp;
        return node;
    }







}

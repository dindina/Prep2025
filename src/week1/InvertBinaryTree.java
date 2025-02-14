package week1;

import binarytree.TreeNode;

/*
https://leetcode.com/problems/invert-binary-tree/description/
Given the root of a binary tree, invert the tree, and return its root.
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSampleTree();
        TreeNode.preOrder(root);
        System.out.println("after inverting ");
        TreeNode inverted = new InvertBinaryTree().invertTree(root);
        TreeNode.preOrder(inverted);


    }

    public TreeNode invert(TreeNode root)
    {
        if ( root == null )
            return null;
        invert(root.left);
        invert(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

    }
        public TreeNode invertTree(TreeNode node) {
            if ( node == null){
                return null;
            }
            TreeNode left = invertTree(node.left);
            TreeNode right = invertTree(node.right);
            if(left !=null)
                System.out.println("left "+ left.val);
            if(right !=null)
            System.out.println("right "+ right.val);
            System.out.println("swapping left %s , right %s ".formatted(left,right));
            TreeNode temp = left;
            node.left = right;
            node.right = temp;
            return node;

        }




}

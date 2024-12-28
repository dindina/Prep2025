package binarytree;

import com.sun.source.tree.Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public static void preOrder(TreeNode node)
    {
        if(node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }



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
        preOrder(root);

    }


}

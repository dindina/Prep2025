package binarytree;

import com.sun.source.tree.Tree;

import java.util.*;

public class DFSIteration {

    static List<Integer> result = new ArrayList<>();
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

        // preorder root , left , right
        // inorder left , root , right
        // postorder left right root


        //new DFSIteration().inorder(root);
        //new DFSIteration().iterateInorder(root);
        //System.out.println(result);

        new DFSIteration().inorder(TreeNode.getSampleBST());
        new DFSIteration().iterateInorder(TreeNode.getSampleBST());
        //System.out.println("rsult " + result);

        /*new DFSIteration().postOrder(root);
        new DFSIteration().iteratePostOrder(root);
        System.out.println("rsult " + result);*/

    }


    // post order left right root
    public void postOrder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.println(root.val+"=>");


    }

    // left , right , root
    public void iteratePostOrder(TreeNode root) {

    }



    // in order left , root , right
    public void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.right);
        System.out.println(root.val+"=>");
        inorder(root.left);
    }

    // left , root , right
    public void iterateInorder(TreeNode root)
    {

        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr= stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

    }

    // pre order root , left , right
    public void preorder(TreeNode root)
    {
        if(root == null)
            return;
        System.out.println(root.val+"=>");
        inorder(root.left);
        inorder(root.right);
    }
    public void iteratePreOrder(TreeNode root) {
        result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr;
        stack.push(root);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            result.add(curr.val);
            if( curr.right != null) {
                stack.push(curr.right);
            }
            if( curr.left != null) {
                stack.push(curr.left);
            }

        }
    }


}

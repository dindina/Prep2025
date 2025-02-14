package week5;

import binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class KthSmallestInBst {

    int count =0;
    int result =0;
    public static void main(String[] args) {
        TreeNode root = TreeNode.getSampleBST();

        System.out.println(new KthSmallestInBst().kthSmallest(root,2));
        System.out.println(new KthSmallestInBst().kthSmallest1(root,2));
    }
    public int kthSmallest1(TreeNode root, int k) {
        preorder(root,k);
        return result;

    }

    public void preorder(TreeNode root, int k)
    {
        if (root == null)
            return ;
        preorder(root.left,k);
        count ++;
        if(count == k)
            result = root.val;

        preorder(root.right,k);
    }


    public int kthSmallest(TreeNode root, int k) {

        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        int count =0 ;
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty())
        {
            while(curr != null)
            {
                stack.push(curr);
                curr  = curr.left;

            }

            curr = stack.pop();
            count++;
            if (count == k)
                return curr.val;
            curr = curr.right;

        }
        return 0;

    }
}

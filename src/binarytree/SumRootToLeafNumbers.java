package binarytree;

public class SumRootToLeafNumbers {

    int number = 0;
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

        System.out.println("ouput " + new SumRootToLeafNumbers().sumNumbers(root));
    }
    public int sumNumbers(TreeNode root) {
        helper(root,number) ; //+ helper(root.right);

        return number;
    }

    private void helper(TreeNode root , int str) {
        if(root != null) {
            str = str *10 + root.val;
            if (root.left == null && root.right == null)
                number += str;
            helper(root.left, str);
            helper(root.right, str);
        }
    }
}

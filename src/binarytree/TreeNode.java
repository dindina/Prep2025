package binarytree;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }


    public static void preOrder(TreeNode node)
    {
        if(node == null)
            return;
        System.out.print(node.val + "->");
        preOrder(node.left);
        preOrder(node.right);

    }

    public static TreeNode getSampleTree()
    {
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
        return root;
    }

    public static TreeNode getSampleBST()
    {
        TreeNode root = new TreeNode();
        root.val = 10;
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();



        root.left = node1;
        node1.val = 8;
        root.right = node2;
        node2.val = 15;

        root.left.left = node3;
        node3.val = 4;
        root.left.right = node4;
        node4.val = 9;
        root.left.left.left = node5;
        node5.val = 2;
        return root;
    }

    public static void main(String[] args) {

        preOrder(TreeNode.getSampleTree());

    }

    @Override
    public String toString()
    {
        return String.valueOf(this.val);
    }



}

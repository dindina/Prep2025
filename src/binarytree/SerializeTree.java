package binarytree;

import java.util.*;

public class SerializeTree {

    public String ser = "";
    public TreeNode result = null;

    private static final String spliter = ",";
    private static final String NN = "X";

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

        String serString =  new SerializeTree().serialize(root);
        System.out.println(serString);
        TreeNode tr = new SerializeTree().deserialize(serString);
        String serString1 =  new SerializeTree().serialize(tr);
        System.out.println(serString1);
        System.out.println(serString1.equals(serString));

        List list =  Arrays.asList("d","f");
        Iterator<String> iter = list.iterator();


    }
    public String serialize(TreeNode root) {
        serHelper(root);
        return ser;
    }
    public void serHelper(TreeNode root){

        if(root == null)
            ser+="null,";
        else {
            ser += root.val + ",";
        }
            serHelper(root.left);
            serHelper(root.right);

    }
    public TreeNode deserialize(String str){



        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(str.split((","))));
        return dserHelper(nodes);

    }

    public TreeNode dserHelper(Queue<String> nodes) {

        String val = nodes.remove();
        System.out.println("val " + val);
        if (val.equals("null")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = dserHelper(nodes);
            node.right = dserHelper(nodes);
            return node;
        }
    }

}

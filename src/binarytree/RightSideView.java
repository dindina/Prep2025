package binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
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

        System.out.println(new RightSideView().rightSideView(root));

        System.out.println(new RightSideView().leftSideView(root));
    }

    private List<Integer> leftSideView(TreeNode root) {

        List<Integer> leftView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ; i < size ; i++)
            {
                TreeNode curr = queue.poll();

                if(i==size-1)
                    leftView.add(curr.val);

                if(curr.right!=null)
                    queue.offer(curr.right);
                if(curr.left!=null)
                    queue.offer(curr.left);
            }
        }
        return leftView;
    }

    private List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0 ; i <size ; i++)
            {
                TreeNode curr = queue.poll();
                if(i == size-1) // right most
                {
                    rightView.add(curr.val);
                }

                if(curr.left !=null)
                {
                    queue.offer(curr.left);
                }
                if(curr.right !=null)
                {
                    queue.offer(curr.right);
                }

            }
        }

        return rightView;

    }
}

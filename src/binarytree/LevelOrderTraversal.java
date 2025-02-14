package binarytree;


/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 */


import java.util.*;

public class LevelOrderTraversal {

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

        System.out.println(new LevelOrderTraversal().levelOrder(root));
        System.out.println(new LevelOrderTraversal().levelOrder1(root));
        System.out.println(new LevelOrderTraversal().levelorder(root));
    }

    private List<List<Integer>> levelOrder1(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0 ; i<size ; i++){

                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left !=  null)
                {
                    queue.offer(curr.left);
                }
                if(curr.right !=  null)
                {
                    queue.offer(curr.right);
                }

            }

            if(!level.isEmpty()){
                result.add(level);
            }
        }
        return result;


    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for ( int i=0 ; i< size ; i++) {

                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;




    }




    public List<List<Integer>> levelorder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();;
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size ; i++)
            {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
            }
            result.add(level);
        }

        return result;

    }














}

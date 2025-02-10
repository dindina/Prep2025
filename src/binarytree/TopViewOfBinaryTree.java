package binarytree;

import java.util.*;

public class TopViewOfBinaryTree {

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

        System.out.println(new TopViewOfBinaryTree().topView(root));

    }

    private List<Integer> topView(TreeNode root) {

        //List<Integer> top = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        Map<Integer,Integer> map = new HashMap<>();

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0 ; i <size ; i++)
            {
                Pair curr =  q.poll();
                int currDistance = curr.distance;
                if(!map.containsKey(currDistance)){
                    map.put(currDistance,curr.node.val);
                }

                if(curr.node.left!=null)
                {
                    q.offer(new Pair(currDistance-1, curr.node.left));
                }
                if(curr.node.right!=null)
                {
                    q.offer(new Pair(currDistance+1, curr.node.right));
                }
            }


        }
        return map.values().stream().toList();


    }

    static class Pair{
        int distance;
        TreeNode node;
        Pair(int distance,TreeNode node)
        {
            this.distance = distance;
            this.node = node;

        }
    }

}

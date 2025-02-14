package binarytree;

import com.sun.source.tree.Tree;

import java.util.*;
public class RightLeftTopView {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSampleTree();

        System.out.println(new RightLeftTopView().rightView(root));
        System.out.println(new RightLeftTopView().leftView(root));
        System.out.println(new RightLeftTopView().topView(root));
    }

    static class Pair{
        TreeNode node;
        int hd;

        Pair(TreeNode node1 , int hd1)
        {
            node = node1;
            hd = hd1;
        }
    }
    public List<Integer> topView(TreeNode root )
    {
        List<Integer> result = new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        Map<Integer,Integer> map = new HashMap<>();

        while(! queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0 ; i<size; i++){

                Pair curr = queue.poll();
                TreeNode currNode = curr.node;
                int hd = curr.hd;
                if(!map.containsKey(hd)) {
                    map.put(hd,currNode.val);
                }

                if(currNode.left != null)
                {
                    queue.offer(new Pair(currNode.left, hd-1));
                }
                if(currNode.right != null)
                {
                    queue.offer(new Pair(currNode.right, hd+1));
                }

            }
        }

        return map.values().stream().toList();


    }


    public List<Integer> leftView(TreeNode node )
    {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){

            int size = queue.size();

            for ( int i =0 ; i <size ; i++){

                TreeNode curr = queue.poll();
                if(i == size-1)
                {
                    result.add(curr.val);
                }

                if(curr.right != null)
                {
                    queue.offer(curr.right);
                }

                if(curr.left != null)
                {
                    queue.offer(curr.left);
                }
            }

        }
        return result;
    }









    public List<Integer> rightView(TreeNode root){

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0 ; i <size ; i++){

                TreeNode curr = queue.poll();
                if( i == size-1){
                    result.add(curr.val);
                }
                if(curr.left != null)
                {
                    queue.offer(curr.left);
                }
                if(curr.right != null)
                {
                    queue.offer(curr.right);
                }

            }

        }
        return result;

    }


}

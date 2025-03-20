package practice;

import binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class StudentMaxAverage {
    public static void main(String[] args) {

        TreeNode node = TreeNode.getSampleTree();
        TreeNode.preOrder(node);
        System.out.println(leftView(node));
        System.out.println(rightView(node));
        System.out.println(topView(node));

        System.out.println("serialize");
        System.out.println(serialize(node));




    }

    public static String serialize(TreeNode node){

        StringBuilder sbr = new StringBuilder();
        serhelper(node,sbr);
        return sbr.toString();
    }
    private static void serhelper(TreeNode root, StringBuilder sbr) {

        if(root == null){
            sbr.append("null,");
            return;
        }else {
            sbr.append(root.val).append(",");
        }
        serhelper(root.left,sbr);
        serhelper(root.right,sbr);

    }



    public TreeNode  deserialize(String str){
        String[] tokens = str.split(",");
        Queue<Integer> q = new LinkedList<>();
        for(String token : tokens){
            q.offer(Integer.parseInt(token));
        }

        return deserhelper(q);

    }

    public TreeNode deserhelper(Queue<Integer> q) {

        Integer curr = q.poll();
        if(curr.equals("null"))
            return null;
        else{
            TreeNode node = new TreeNode();
            node.val=curr;
            node.left = deserhelper(q);
            node.right = deserhelper(q);
            return node;
        }

    }


    static class Pair{
        Pair(int i, TreeNode n)
        {
            distance=i;
            node=n;
        }
        int distance;
        TreeNode node;
    }
    public static List<Integer> topView(TreeNode node){

        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,node));

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0 ; i< size ; i++){
                Pair curr = q.poll();

                if(!map.containsKey(curr.distance)){
                    map.put(curr.distance,curr.node);
                }

                if(curr.node.left!= null){
                    //map.put(curr.distance-1, curr.node.left);
                    q.offer(new Pair(curr.distance-1, curr.node.left));

                }
                if(curr.node.right!= null){
                    //map.put(curr.distance+1, curr.node.right);
                    System.out.println("offering " + (curr.distance+1) +"," + curr.node.right.val );
                    q.offer(new Pair(curr.distance+1, curr.node.right));
                }
            }
        }
        for (TreeNode temp : map.values())
        {
            result.add(temp.val);
        }
        return result;

    }
    public static List<Integer> rightView(TreeNode node){
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode > q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0 ; i<size ; i++)
            {
                TreeNode curr = q.poll();
                if(i == size -1){
                    result.add(curr.val);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }


        }
        return result;
    }


    public static List<Integer> leftView(TreeNode node){

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i< size; i++)
            {
                TreeNode curr = q.poll();

                if( i == size -1){
                    result.add(curr.val);
                }

                if(curr.right != null)
                {
                    q.offer(curr.right);
                }

                if(curr.left != null)
                {
                    q.offer(curr.left);
                }

            }
        }
        return result;
    }




}

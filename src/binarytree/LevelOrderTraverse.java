package binarytree;

import common.Utils;

import java.util.*;

public class LevelOrderTraverse {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getSampleTree();
        TreeNode.preOrder(root);
        System.out.println();
        System.out.println(new LevelOrderTraverse().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        result.add(Arrays.asList(root.val));

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0 ; i<size; i++ ){
                TreeNode curr = q.poll();
                if(curr.left != null)
                {
                    level.add(curr.left.val);
                    q.offer(curr.left);
                }
                if(curr.right != null)
                {
                    level.add(curr.right.val);
                    q.offer(curr.right);
                }
            }
            if(!level.isEmpty()){
                result.add(level);
            }


        }
        return result;
    }
}

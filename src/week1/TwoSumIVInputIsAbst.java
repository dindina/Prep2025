package week1;

import binarytree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.
 */
public class TwoSumIVInputIsAbst {

    public boolean findTarget(TreeNode root, int k) {
      Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, Set<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}

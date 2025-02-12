package binarytree;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
 binary search tree.

 */
public class ConvertSortedArrayToBinarySearchTree {

    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {

        this.nums = nums;
        return helper(0,nums.length-1);
    }

    private TreeNode helper(int low, int high) {

        if(low > high)
            return null;
        int mid = (low+high)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(low,mid-1);
        root.left = helper(mid+1,high);
        return root;

    }
}

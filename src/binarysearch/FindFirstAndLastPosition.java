package binarysearch;
/*

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FindFirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,8,8,10};
        int target = 8;
        System.out.println(new FindFirstAndLastPosition().searchRange(nums,target));
    }
    public int searchRange(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;

        while(left < right){

            int mid = (left+right)/2;

            if(target > nums[mid])
            {
                left=mid+1;
            }
            else {
                right=mid;
            }

        }
        if(nums[left] ==target)
            return left;
        return -1;

    }
}

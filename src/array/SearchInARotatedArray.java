package array;

/*
https://neetcode.io/problems/find-target-in-rotated-sorted-array

Search in Rotated Sorted Array
You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:

[3,4,5,6,1,2] if it was rotated 4 times.
[1,2,3,4,5,6] if it was rotated 6 times.
Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.

You may assume all elements in the sorted rotated array nums are unique,

A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?

Example 1:

Input: nums = [3,4,5,6,1,2], target = 1

Output: 4
Example 2:

Input: nums = [3,5,6,0,1,2], target = 4

Output: -1
Constraint
 */
public class SearchInARotatedArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 8,9,10,3,5,6,7 };
        System.out.println(findIndex(nums,7));

    }


    public static int findIndex(int[] nums, int target){

        if(nums[0] == target )
            return 0;
        if(nums[nums.length-1] == target )
            return nums.length-1;

        int left = 0;
        int right = nums.length-1;

        while(left <= right){

            int mid = (left+right)/2;

            if( nums[mid] == target){
                return mid;
            }

            // {7,8,9,10,3,5,6} target 6
            // sorted left half
            if(nums[left] <= nums[mid]){

                if( nums[left] <= target || target <= nums[mid]){
                    right = mid -1;
                }else {
                    left = mid +1;
                }
            }
            else{
                if( nums[mid] <= target || target <= nums[right]){
                    left = mid +1;
                }
                else{
                    right = mid -1;
                }

            }


        }
        return -1;

    }
}

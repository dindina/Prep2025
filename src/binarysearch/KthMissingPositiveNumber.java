package binarysearch;

/*
https://leetcode.com/problems/kth-missing-positive-number/description/
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7};
        int target = 5;
        System.out.println(new KthMissingPositiveNumber().findKthPositiveEasy(nums,target));
        System.out.println(new KthMissingPositiveNumber().findKthPositive(nums,target));

    }

    public int findKthPositiveEasy(int[] arr, int k) {
        for(int i=0; i< arr.length; i++)
        {
            if(arr[i]<=k)
                k++;
        }
        return k;
    }

    public int findKthPositive(int[] nums, int k) {
        int left =0;
        int right = nums.length-1;

        while( left <= right) {

            int mid = (left+right)/2;
            int missing = nums[mid] - (mid+1); // diff of the number and its position
            if(k>missing)
            {
                left= mid+1;
            }else {
                right= mid-1;
            }

        }
        return left+k;
    }
}

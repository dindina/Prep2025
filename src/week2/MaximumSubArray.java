package week2;

/*
https://leetcode.com/problems/maximum-subarray/description/

Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int [] nums = new int[] {-1,-1,-2,-2 };
        System.out.println(new MaximumSubArray().maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0] ;
        int windowSum = 0;

        for ( int i : nums)
        {
            windowSum += i;
            windowSum = Math.max(windowSum , i);
            maxsum = Math.max(maxsum,windowSum);

        }
        return maxsum;


    }

}

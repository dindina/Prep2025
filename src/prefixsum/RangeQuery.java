package prefixsum;

import java.util.Arrays;

/*
https://leetcode.com/problems/range-sum-query-immutable/description/
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

 */
public class RangeQuery {

    public static void main(String[] args) {

        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        RangeQuery rangeQuery = new RangeQuery(nums);

        System.out.println(rangeQuery.sumRange(0,4));

    }
    int[] prefix = null;
    RangeQuery(int[] nums) {
        prefix = new int[nums.length+1];

        prefix[0] = 0; // dummy element
        //[-2, 0, 3, -5, 2, -1]
        //[0,-2,-2, 1 ,-4,2, -2 ,-3]
        for(int i=1 ; i< nums.length+1 ; i++)
        {
             prefix[i] = prefix[i-1] + nums[i-1]; // p[1] = p[0]+ nums[0];p[2] = p[1]+ nums[1];
        }

        System.out.println(Arrays.toString(prefix));


    }
    public int sumRange(int left, int right) {

        return prefix[right+1] - prefix[left];
    }
}

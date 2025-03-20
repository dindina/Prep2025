package dynamic;


/*
Given an integer array nums, find a subarray that has the largest product within the array and return it.

A subarray is a contiguous non-empty sequence of elements within an array.

You can assume the output will fit into a 32-bit integer.

Example 1:

Input: nums = [1,2,-3,4]

Output: 4
Example 2:

Input: nums = [-2,-1]

Output: 2
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,-3,4,6};

        System.out.println(new MaximumProductSubArray().maxProduct(nums));
        System.out.println(new MaximumProductSubArray().maxSum(nums));

    }
    // kadanes algorithm
    public int maxProduct(int[] nums) {

        int max=Integer.MIN_VALUE;
        int prefix=1;
        int suffix=1;
        int n = nums.length;
        for(int i=0; i<n;i++)
        {
            prefix*=nums[i]; // foward
            suffix*=nums[n-i-1]; // backward
            max = Math.max(max, Math.max(prefix,suffix));
            if(prefix==0)  prefix=1;
            if(suffix==0)  suffix=1;
        }
        return max;
    }

    public int maxSum(int[] nums) {

        int sum = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i=1 ; i < nums.length; i++)
        {
            sum+=nums[i];
            sum = Math.max(sum,nums[i]);
            max = Math.max(Math.max(sum,nums[i]),max);

        }
        return max;

    }

}

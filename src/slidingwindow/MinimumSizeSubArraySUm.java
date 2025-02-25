package slidingwindow;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
public class MinimumSizeSubArraySUm {

    public static void main(String[] args) {
        int [] nums = new int[] {2,3,1,2,4,3};
        int target =7;
        System.out.println(new MinimumSizeSubArraySUm().minSubArrayLen(target,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {

        int left=0;
        int sum = 0 ;
        int min = Integer.MAX_VALUE;
        for(int right =0 ; right < nums.length ; right++)
        {
            sum+=nums[right];
            while(sum >= target)
            {
                min = Math.min(min,right-left+1);
                sum-=nums[left++];
            }
        }
        return min;

    }
}

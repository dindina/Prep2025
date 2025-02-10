package week5;

import java.util.*;
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

 */
public class CombinationSum {

    public static void main(String[] args) {
        int [] nums = new int[] {2,3,5};
        int target = 8;

        System.out.println(new CombinationSum().combinationSum(nums,target));
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,target, result , new ArrayList<>(), 0);
        return result;

    }

    private void backtrack(int[] nums, int target, List<List<Integer>> result , ArrayList<Integer> objects , int pos) {

        if(target<0)
            return;

        if(target == 0)
        {
            result.add(new ArrayList<>(objects));
            return;
        }

        for(int i=pos ; i < nums.length ; i++)
        {
            objects.add(nums[i]);
            int remaining = target-nums[i];
            backtrack(nums,remaining,result,objects,i);
            objects.remove(objects.size()-1);
        }

    }

    int sum(List<Integer> nums)
    {
        int sum=0;
        for(int i : nums)
            sum+=i;
        return sum;
    }



}

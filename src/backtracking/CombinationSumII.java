package backtracking;

import java.util.*;

/*
https://neetcode.io/problems/combination-target-sum-ii
You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.

Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.

Example 1:

Input: candidates = [9,2,2,4,6,1,5], target = 8

Output: [
  [1,2,5],
  [2,2,4],
  [2,6]
]
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int [] nums = new int[]{9,2,2,4,6,1,5};
        int target=8;
        System.out.println(combinationSum2(nums,8));
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backrack(0, nums , result , new ArrayList<>(), target);

        return result;

    }

    private static void backrack(int pos, int[] nums, List<List<Integer>> result, ArrayList<Integer> objects, int target) {

        if(target == 0) {
            result.add(new ArrayList<>(objects));
            return;
        }



        for(int i = pos ; i < nums.length; i++)
        {
            if( i >pos && nums[i] == nums[i-1]) continue;
            objects.add(nums[i]);
            backrack(i+1,nums,result,objects,target-nums[i]);
            objects.remove(objects.size()-1);
        }
    }
}

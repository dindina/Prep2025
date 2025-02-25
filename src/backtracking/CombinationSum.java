package backtracking;


import java.util.ArrayList;
import java.util.List;

/*
https://neetcode.io/problems/combination-target-sum
You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.

The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.

Example 1:

Input:
nums = [2,5,6,9]
target = 9

Output: [[2,2,5],[9]]
 */
public class CombinationSum {

    public static void main(String[] args) {
        int []  nums = new int[]{2,5,6,9};
        int sum = 9;
        System.out.println(getComb(nums,sum));
    }

    public static  List<List<Integer>> getComb(int [] nums , int sum)
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack2(nums,0,result, new ArrayList<>(), sum);
        return result;
    }

    private static void backtrack2(int[] nums, int start , List<List<Integer>> result, ArrayList<Integer> objects, int target) {

        if(target == 0)
        {
            result.add(new ArrayList<>(objects));
            return;
        }

        for(int i=start ; i < nums.length; i++)
        {
            if(nums[i]>target) continue;
            objects.add(nums[i]);
            backtrack2(nums,i,result,objects,target-nums[i]);
            objects.remove(objects.size()-1);
        }
    }
}

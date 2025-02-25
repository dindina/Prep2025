package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://neetcode.io/problems/subsets
Given an array nums of unique integers, return all possible subsets of nums.

The solution set must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,3]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {

    public static void main(String[] args) {
        int []  nums = new int[]{1,2,3};

        System.out.println(subsets(nums));
    }

    public static  List<List<Integer>> subsets(int [] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        backtrack1(nums,result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack1(int[] nums, List<List<Integer>> result, ArrayList<Integer> objects , int start) {

        //if(objects.size() >=0)
        {
            result.add(new ArrayList<>(objects));
        }

       for(int i=start; i <nums.length ; i++) {

           objects.add(nums[i]);
           backtrack1(nums, result, objects, i);
           objects.remove(objects.size()-1);

       }


    }
}

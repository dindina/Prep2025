package backtracking;


import java.util.*;

/*
https://neetcode.io/problems/subsets-ii
You are given an array nums of integers, which may contain duplicates. Return all possible subsets.

The solution must not contain duplicate subsets. You may return the solution in any order.

Example 1:

Input: nums = [1,2,1]

Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
Example 2:

Input: nums = [7,7]

Output: [[],[7], [7,7]]

 */
public class SubsetsII {

    public static void main(String[] args) {
        int []  nums = new int[]{1,2,1};

        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,result,new ArrayList<>(),0);
        return result;

    }

    public static void backtrack(int[] nums , List<List<Integer>> result , List<Integer> objects, int start)
    {
        result.add(new ArrayList<>(objects));

        for(int i=start; i <nums.length; i++)
        {
            if(i > start && nums[i] == nums[i-1]) continue;
            objects.add(nums[i]);
            backtrack(nums,result,objects,i+1);
            objects.remove(objects.size()-1);

        }
    }
}

package week5;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/

Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

 */
public class Subsets {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int [] nums = new int[]{ 1,2,3};

        System.out.println("result " + new Subsets().subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums,result,new ArrayList<>(), 0);
        return result;

    }

    private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> objects, int pos) {


        result.add(new ArrayList<>(objects));


        for(int i=pos ; i <nums.length ; i++)
        {
            objects.add(nums[i]);
            System.out.println(objects);
            backtrack(nums,result,objects,i+1);
            objects.remove(objects.size()-1);
        }
    }
}

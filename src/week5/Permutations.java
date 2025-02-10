package week5;
import java.util.*;

/*
https://leetcode.com/problems/permutations/description/
Given an array nums of distinct integers, return all the possible
permutations
. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 */
public class Permutations {

    public static void main(String[] args) {
        int [] nums = new int[]{ 1,2,3};

        System.out.println(new Permutations().permute(nums));
    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,result,new ArrayList<>());
        return result;

    }

    private void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> objects) {

        if(objects.size() == nums.length)
        {
            System.out.println("adding to result for " + objects);
            result.add(new ArrayList<>(objects));
            return;
        }
        for(int i=0; i< nums.length ; i++)
        {
            System.out.println("before for " + objects);
            if(objects.contains(nums[i])) continue;
            objects.add(nums[i]);
            System.out.println("checking for " + objects);
            backtrack(nums,result,objects);
            System.out.println("removing " + objects.remove(objects.size()-1));
        }

    }
}

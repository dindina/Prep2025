package backtracking;

import common.Utils;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/combinations/
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(3,2));
    }
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = i + 1;
        }
        //Utils.printArray(nums);

        backtrack(nums,k, result, new ArrayList<>(),0);


        return result;

    }

    private void backtrack(int[] nums, int k, List<List<Integer>> result, ArrayList<Integer> objects, int pos) {
        if(objects.size() == k) {
            result.add(new ArrayList<>(objects));
            return;
        }

        for(int i= pos; i <= nums.length-1 ; i++)
        {
            if(objects.contains(nums[i])) continue;
            objects.add(nums[i]);
            backtrack(nums,k,result,objects,i+1);
            objects.remove(objects.size()-1);
        }

    }
}

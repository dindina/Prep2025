package week3;

import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

 */
public class ThreeSum {

    public static void main(String[] args) {
        int [] nums = new int[] {0,1,1};
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length ==0)
            return result;
        Arrays.sort(nums);
        int left, right =0;
        Set<String> set = new HashSet<>();
        for(int i=0 ; i < nums.length ; i++)
        {
            left = i+1;
            right = nums.length-1;

            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if ( sum ==0)
                {
                    List<Integer> triplet = new ArrayList<>();
                    String str = nums[i] +"," + nums[left] + "," + nums[right];
                    if(!set.contains(str))
                    {
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        result.add(triplet);
                        set.add(str);
                    }


                    left ++;
                    right--;
                

                }else if (sum >0)
                {
                    left ++;
                }
                else {
                    right--;
                }
            }
        }
        return result;

    }
}

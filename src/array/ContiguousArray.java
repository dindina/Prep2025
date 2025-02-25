package array;

import java.util.*;

/*
https://leetcode.com/problems/contiguous-array/description/
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 */
public class ContiguousArray {

    public static void main(String[] args) {
        int[] nums = new int [] { 0,1,0};
        System.out.println(new ContiguousArray().findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0, sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += (nums[i] == 1)?1:-1;
            System.out.println("sum " + sum);
            // Array from index 0 to i contains equal number of 0's and 1's
            if(sum == 0) {
                maxlen = Math.max(maxlen, i + 1);
            }
            System.out.println("checking " + map);
            if(map.containsKey(sum)) { // envountering same count twice
                //it means that the number of zeros and ones are equal between the indices corresponding to the equal count values.
                System.out.println("i " + i);
                System.out.println("sum - > " + sum);
                System.out.println("i - map.get(count) " + (i - map.get(sum)));
                maxlen = Math.max(maxlen, i - map.get(sum));
                //System.out.println("maxlen one " + maxlen);
                //System.out.println(map);
            } else {
                System.out.println("putting " + sum +","+i);
                map.put(sum, i);
                System.out.println("newmap " + map);
            }
        }
        return maxlen;

    }
}

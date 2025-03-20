package slidingwindow;

import java.util.*;

/*
https://leetcode.com/problems/count-the-number-of-good-subarrays/description/?envType=problem-list-v2&envId=ad2okg2g
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1,1,1], k = 10
Output: 1
Explanation: The only good subarray is the array nums itself.
Example 2:

Input: nums = [3,1,4,3,2,2,4], k = 2
Output: 4
Explanation: There are 4 different good subarrays:
- [3,1,4,3,2,2] that has 2 pairs.
- [3,1,4,3,2,2,4] that has 3 pairs.
- [1,4,3,2,2,4] that has 2 pairs.
- [4,3,2,2,4] that has 2 pairs.

 */
public class CountGoodSubArray {

    public static void main(String[] args) {
        int [] nums = new int[] { 3,1,4,3,2,2,4};
        int k = 2 ;

        System.out.println(countGood(nums,k));

    }

    public static long countGood(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int l = 0;
        long ans=0;
        for(int r=0;r<n;r++) {
            int currFreq = freq.getOrDefault(nums[r], 0);
            count+=currFreq;
            freq.put(nums[r], currFreq+1);
            System.out.println("count "  + count);
            System.out.println("adding "  + freq);
            //3,1,4,3,2,2,4
            while(count >= k) {
                count = count - (freq.get(nums[l])-1);
                freq.put(nums[l], freq.get(nums[l])-1);
                System.out.println("reducing "  + freq);
                l++;
            }
            ans+=l;
        }
        return ans;

    }
}

package slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

/*
https://leetcode.com/problems/sliding-subarray-beauty/description/
Given an integer array nums containing n integers, find the beauty of each subarray of size k.

The beauty of a subarray is the xth smallest integer in the subarray if it is negative, or 0 if there are fewer than x negative integers.

Return an integer array containing n - k + 1 integers, which denote the beauty of the subarrays in order from the first index in the array.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
Output: [-1,-2,-2]
Explanation: There are 3 subarrays with size k = 3.
The first subarray is [1, -1, -3] and the 2nd smallest negative integer is -1.
The second subarray is [-1, -3, -2] and the 2nd smallest negative integer is -2.
The third subarray is [-3, -2, 3] and the 2nd smallest negative integer is -2.
 */
public class SlidingSubarrayBeauty {

    public static void main(String[] args) {
        int [] nums = new int[] { 1,-1,-3,-2,3};
        int k = 3 ;
        int x = 2 ;
        System.out.println(Arrays.toString(getSubarrayBeauty(nums,k,x)));

    }
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int left = 0;
        int right =0 ;
        int[] result = new int[(nums.length+1)/2];
        LinkedList window = new LinkedList();
        int index =0;
        int windowmin = Integer.MAX_VALUE;
        while(right < k){
            window.addLast(nums[right]);
            windowmin = Math.min(windowmin,nums[right]);
            right++;

        }
        System.out.println("first window " +window);
        int  resultIndex=0;
        int ret = findMin(window,x);
        System.out.println("ret  " + ret);
        result[resultIndex++] = ret;


        //System.out.println("result  " + Arrays.toString(result));
        // { 1,-1,-3,-2,3};
        for(; right < nums.length ; right++)
        {
            window.removeFirst();
            window.addLast(nums[right]);
            System.out.println(" window " +window);
            result[resultIndex++] = findMin(window,x);


        }

        return result;
    }

    public static int findMin(LinkedList<Integer> window, int x){

        Collections.sort(window);
        //System.out.println("sorted window " + window);
        //System.out.println("returning  " +  window.get(x));
        return window.get(x-1);
    }


}

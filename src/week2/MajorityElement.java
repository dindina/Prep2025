package week2;

/*
https://leetcode.com/problems/majority-element/description/
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {

    public static void main(String[] args) {
        int [] nums = new int[] {3,2,3,2,2,3,3 };
        System.out.println(new MajorityElement().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
             count ++;
            }else {
                count --;
            }
            System.out.println("count " + count);
        }

        return candidate;
    }
}


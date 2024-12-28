package week2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.


 */
public class ContainsDuplicate {


    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (final int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}

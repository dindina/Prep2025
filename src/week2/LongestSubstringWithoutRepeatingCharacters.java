package week2;

import java.util.HashSet;
import java.util.Set;

/*

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstringWithoutRepeatingCharacters {


    public static void main(String[] args) {
        String str = "pwwkew";

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right <s.length() ; right++)
        {

            while(set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

}

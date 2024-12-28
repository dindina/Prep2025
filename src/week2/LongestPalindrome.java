package week2;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-palindrome/
Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


solutuion logic
To determine when a letter from the given string is eligible to be a part of the longest palindrome, let's examine our example palindromes:

"acbbca": in a palindrome of even length, each character must appear an even number of times.
"madam": in a palindrome of odd length, a single additional character may be counted for the center character.

 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {

        int result = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray())
        {
                if(set.contains(ch))
                {
                    set.remove(ch);
                    result +=2;

                }else {
                    set.add(ch);

                }
        }
        if(!set.isEmpty())
            result++;

        return result;
    }
}

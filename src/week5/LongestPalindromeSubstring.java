package week5;

/*
https://leetcode.com/problems/longest-palindromic-substring/
Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String str = "ababadamm  a-malayalam";
        System.out.println(new LongestPalindromeSubstring().longestPalindrome(str));
    }
    public String longestPalindrome(String s) {
    // logic is to expand from middle
        int start = 0, maxLength = 0;
    for(int i= 0 ; i<s.length() ; i++)
    {
        int len1 = expandFromMiddle(s,i,i);
        int len2 = expandFromMiddle(s,i,i+1);
        // Find the maximum palindrome length
        int len = Math.max(len1, len2);

        // Update the starting point and max length if a longer palindrome is found
        if (len > maxLength) {
            maxLength = len;
            start = i - (len - 1) / 2;
        }

    }
        return s.substring(start, start + maxLength);

    }

    private int expandFromMiddle(String s, int left, int right) {
        System.out.println("left " + left);
        System.out.println("right " + right);

        while(left>=0 && right< s.length() && s.charAt(left) == s.charAt(right))
        {
            System.out.println("inside");
            left--; //expand left
            right++; //expand right;

        }
        System.out.println("return " + (right-left-1));
        return right-left-1;
    }
}

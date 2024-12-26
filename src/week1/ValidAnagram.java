package week1;

/*
https://leetcode.com/problems/valid-anagram
Given two strings s and t, return true if t is an
anagram
 of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) {

        System.out.println(new ValidAnagram().isAnagram("anagram","nagaram"));

    }
    public boolean isAnagram(String s, String t) {

        if(t.length() != s.length())
            return false;
        char[] array = new char[128];


        for(char ch : s.toCharArray())
        {
            array[ch] += 1;
        }

        for(char ch : t.toCharArray())
        {
            array[ch] -= 1;
        }

        for(int i=0; i < array.length ; i++)
        {
            if(array[i] !=0)
            {
                return false;
            }
        }
        return true;
    }
}

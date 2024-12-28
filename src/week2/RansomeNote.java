package week2;

/*
https://leetcode.com/problems/ransom-note/description/
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class RansomeNote {

    public static void main(String[] args) {
        System.out.println(new RansomeNote().canConstruct("aa","ab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int [] chars = new int [128];
        for(char ch : magazine.toCharArray())
        {
            chars[ch] += 1;
        }

        for(char ch : ransomNote.toCharArray())
        {
            chars[ch] -= 1;
            if(chars[ch]  < 0)
                return false;
        }

        return true;
    }
}

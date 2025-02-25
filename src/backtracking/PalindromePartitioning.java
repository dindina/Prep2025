package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://neetcode.io/problems/palindrome-partitioning
Given a string s, split s into substrings where every substring is a palindrome. Return all possible lists of palindromic substrings.

You may return the solution in any order.

Example 1:

Input: s = "aab"

Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"

Output: [["a"]]
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(new PalindromePartitioning().partition(str));

    }
    public List<List<String>> partition(String str) {


        List<List<String>> result = new ArrayList<>();
        backtrackString(str,0,result,new ArrayList<>());
        return result;
    }

    private void backtrackString(String str, int start, List<List<String>> result, ArrayList<String> objects) {

        if(start >= str.length())
        {
            result.add(new ArrayList<>(objects));
            return;
        }

        for(int i = start ; i < str.length() ; i++)
        {
            if(isPalindrome(start,i,str))
            {
                objects.add(str.substring(start,i+1));
                backtrackString(str,i+1,result,objects);
                objects.remove(objects.size()-1);
            }
        }
    }

    public boolean isPalindrome(int start , int end , String str){
        while(start < end)
        {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;

        }
        return true;
    }
}

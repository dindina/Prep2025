package slidingwindow;

import java.util.*;

/*
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.



Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubStringWithAtLeastKRepeatingChars {

    public static void main(String[] args) {
        String str = "aaabb";
        int k =3;
        System.out.println(longestSubstring(str,k));

    }

    public static int longestSubstring(String s, int k) {
        int max = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        //aaabb , aaa
        for (int right =0; right < s.length(); right++)
        {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar,0)+1);
            System.out.println("rightChar " + rightChar);
            System.out.println("adding " + map);
            while(checkFreq(map,k))
            {
                char leftChar = s.charAt(left++);
                System.out.println("leftChar " + leftChar);
                int freq = map.get(leftChar);

                if(freq -1 == 0)
                {
                    map.remove(leftChar);
                    System.out.println("remove " + map);
                }else {
                    map.put(leftChar,freq-1);
                    System.out.println("changing " + map);
                }

            }
            max = Math.max(max,right-left+1);

            System.out.println("max " + max);



        }
        return max;
    }

    private static boolean checkFreq(Map<Character, Integer> map, int k) {
        Collection<Integer> list =  map.values();
        for(int i : list){
            System.out.println("i = " + i);
            if(i < k) {
                return false;
            }

        }
        System.out.println("return true");
        return true;
    }
}

package slidingwindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {


    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for(int right =0 ; right < s.length(); right++)
        {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;

            }

            set.add(s.charAt(right));
            max = Math.max(max,set.size());


        }
        return max;


    }

}

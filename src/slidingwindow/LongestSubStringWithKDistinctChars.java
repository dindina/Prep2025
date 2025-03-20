package slidingwindow;

import java.util.*;

public class LongestSubStringWithKDistinctChars {

    public static void main(String[] args) {
        String str = "dindina";
        System.out.println(lengthOfLongestSubstringKDistinct(str,3));
    }
    public static int lengthOfLongestSubstringKDistinct(String str, int k) {

        Map<Character,Integer> map = new HashMap<>();
        int max =0;

        int left =0 ;
        for(int right =0; right < str.length() ; right++)
        {
            //dindina
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            System.out.println("adding " + map);
            while(map.size() > k ) // this means the map has more than k distinct characters , so we are going to slide the window
            {
                char leftch = str.charAt(left++); //
                System.out.println("leftch " + leftch);
                int count = map.get(leftch);
                if(count-1 == 0 ) {
                    map.remove(leftch);
                    System.out.println("after removing " + map);
                }
                else {
                    map.put(leftch, count - 1);
                    System.out.println("decreasing " + map);
                }
            }
            max = Math.max(max,right-left+1);

        }
        return max;

    }
}
